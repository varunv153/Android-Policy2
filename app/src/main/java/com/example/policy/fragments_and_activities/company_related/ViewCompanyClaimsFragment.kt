package com.example.policy.fragments_and_activities.company_related

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.policy.R
import com.example.policy.databinding.FragmentViewCompanyClaimsBinding
import com.example.policy.fragments_and_activities.recyclerview_specific.MyAdapterClaim
import com.example.policy.models.Claim
import com.example.policy.viewmodels.MyAdapterViewModel
import com.example.policy.viewmodels.ViewClaimsCompanyViewModel

class ViewCompanyClaimsFragment : Fragment(), MyAdapterClaim.ItemClickListener
{
    private var binding: FragmentViewCompanyClaimsBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    private val viewModel2: ViewClaimsCompanyViewModel by viewModels()
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentViewCompanyClaimsBinding.inflate(inflater,container,false)
        viewModel2.viewClaimsOfCompany()
        viewModel2.result.observe(viewLifecycleOwner,{
            lateinit var claims:MutableList<Claim>
            try {
                if (it.isSuccessful) {
                    Log.e("success",it.body().toString())
                    claims = it.body()!!
                }
                else {
                    val errorbody = it.errorBody()!!.string()
                    Log.e("errorbody", errorbody)
                }
            }
            catch(e:Exception)
            {
                Log.e("Exception",e.toString())
            }
            val recyclerView = binding?.recyclerViewClaims
            recyclerView?.adapter = MyAdapterClaim(container!!.context, claims,this)
            recyclerView?.layoutManager = LinearLayoutManager(context)
        })
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewCompanyClaimsFragment = this
    }
    override fun onItemClick(claim: Claim){
        viewModel.claim = claim
        viewModel.claim?.let { Log.e("claim id", it.id.toString()) }
        findNavController().navigate(R.id.action_viewCompanyClaimsFragment_to_detailsClaimFragment)
    }
}