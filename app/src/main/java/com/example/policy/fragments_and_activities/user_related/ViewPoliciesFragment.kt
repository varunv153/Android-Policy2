package com.example.policy.fragments_and_activities.user_related

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
import com.example.policy.databinding.FragmentViewPoliciesBinding
import com.example.policy.fragments_and_activities.company_related.MyAdapter
import com.example.policy.models.Policy
import com.example.policy.viewmodels.MyAdapterViewModel
import com.example.policy.viewmodels.ViewPoliciesViewModel

class ViewPoliciesFragment : Fragment(), MyAdapter.ItemClickListener
{
    private var binding: FragmentViewPoliciesBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    val viewModel2: ViewPoliciesViewModel by viewModels()
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentViewPoliciesBinding.inflate(inflater,container,false)
        viewModel2.viewPolicies()
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
            recyclerView?.adapter = MyAdapter(container!!.context, policies,this)
            recyclerView?.layoutManager = LinearLayoutManager(context)
        })
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewPoliciesFragment = this
    }
    override fun onItemClick(policy: Policy){
        viewModel.policy = policy
        viewModel.policy?.let { Log.e("company name", it.company_adminemail) }
        findNavController().navigate(R.id.action_viewPoliciesFragment_to_detailsPolicyFragment)
    }
}