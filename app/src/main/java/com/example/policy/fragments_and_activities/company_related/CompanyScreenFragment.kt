package com.example.policy.fragments_and_activities.company_related

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.policy.R
import com.example.policy.databinding.FragmentCompanyScreenBinding
import com.example.policy.fragments_and_activities.jwtToken

class CompanyScreenFragment : Fragment()
{
    private var binding: FragmentCompanyScreenBinding? = null
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentCompanyScreenBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.companyScreenFragment = this
    }
    fun renderCreatePolicy()
    {
        Log.e("tag","company create policy")
        findNavController().navigate(R.id.action_companyScreenFragment_to_createPolicyFragment)
    }
    fun renderViewPoliciesCompany()
    {
        Log.e("tag","company create policy")
        findNavController().navigate(R.id.action_companyScreenFragment_to_viewCompanyPoliciesFragment)
    }
    fun renderViewBonds()
    {
        Log.e("tag","company create policy")
        //findNavController().navigate(R.id.action_mainScreenFragment_to_companySignupFragment)
    }
    fun renderViewClaimsCompany()
    {
        Log.e("tag","company create policy")
        //findNavController().navigate(R.id.action_mainScreenFragment_to_companySignupFragment)
    }
    fun logoutCompany()
    {
        Log.e("tag","company create policy")
        jwtToken = "none"
        findNavController().navigate(R.id.action_companyScreenFragment_to_mainScreenFragment)
    }
}