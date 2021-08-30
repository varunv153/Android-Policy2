package com.example.policy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.policy.databinding.FragmentViewCompanyPoliciesBinding
import com.example.policy.models.Policy

class ViewCompanyPoliciesFragment : Fragment(), MyAdapter.ItemClickListener
{
    private var binding: FragmentViewCompanyPoliciesBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentViewCompanyPoliciesBinding.inflate(inflater,container,false)
        val recyclerView = binding?.recyclerViewCompanyPolicies
        recyclerView?.adapter = MyAdapter(container!!.context, mutableListOf(Policy(1,"first policy",3000,300000, "maxbupa@gmail.com","HIV",95.3),Policy(2,"second policy",5000,500000, "bajaj@gmail.com","Modern",95.3) ), this)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.viewCompanyPoliciesFragment = this
    }
    override fun onItemClick(policy: Policy) {
        viewModel.policy = policy
        viewModel.policy?.let { Log.e("company name", it.company_adminemail) }
        findNavController().navigate(R.id.action_viewCompanyPoliciesFragment_to_detailsPolicyFragment)
    }
}