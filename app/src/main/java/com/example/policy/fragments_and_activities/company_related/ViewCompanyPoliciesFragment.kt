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
import com.example.policy.databinding.FragmentViewCompanyPoliciesBinding
import com.example.policy.fragments_and_activities.recyclerview_specific.MyAdapterPolicy
import com.example.policy.models.Policy
import com.example.policy.viewmodels.MyAdapterViewModel
import com.example.policy.viewmodels.ViewCompanyPoliciesViewModel

class ViewCompanyPoliciesFragment : Fragment(), MyAdapterPolicy.ItemClickListener
{
    private var binding: FragmentViewCompanyPoliciesBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    val viewModel2:ViewCompanyPoliciesViewModel by viewModels()
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentViewCompanyPoliciesBinding.inflate(inflater,container,false)
        viewModel2.viewPoliciesOfCompany()
        viewModel2.result.observe(viewLifecycleOwner,{
            lateinit var policies:MutableList<Policy>
            try {
                if (it.isSuccessful) {
                    Log.e("success",it.body().toString())
                    policies = it.body()!!
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
            val recyclerView = binding?.recyclerViewCompanyPolicies
            recyclerView?.adapter = MyAdapterPolicy(container!!.context, policies,this)
            recyclerView?.layoutManager = LinearLayoutManager(context)
        })
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewCompanyPoliciesFragment = this
    }
    override fun onItemClick(policy: Policy){
        viewModel.policy = policy
        viewModel.policy?.let { Log.e("company name", it.company_adminemail) }
        findNavController().navigate(R.id.action_viewCompanyPoliciesFragment_to_detailsPolicyFragment)
    }
}