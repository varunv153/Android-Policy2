package com.example.policy.fragments_and_activities.company_related

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.policy.databinding.FragmentCreatePolicyBinding
import com.example.policy.models.Company
import com.example.policy.models.NewPolicy
import com.example.policy.viewmodels.CompanySignupViewModel
import com.example.policy.viewmodels.CreatePolicyViewModel

class CreatePolicyFragment : Fragment()
{
    private var binding: FragmentCreatePolicyBinding? = null
    private lateinit var viewModel: CreatePolicyViewModel
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        viewModel = ViewModelProvider(this).get(CreatePolicyViewModel::class.java)
        binding = FragmentCreatePolicyBinding.inflate(inflater,container,false)
        binding?.displayInfo?.text = viewModel.result.value.toString()
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.createPolicyFragment = this
    }
    private fun getNewPolicy(): NewPolicy
    {
        val policyWording =  binding?.policyWording?.text.toString()
        val csr =  binding?.csr?.text.toString().toDouble()
        val exemptions =  binding?.exemptions?.text.toString()
        val roomRentCap =  binding?.roomRentCap?.text.toString().toInt()
        val sumInsured =  binding?.sumInsured?.text.toString().toInt()
        return NewPolicy(policyWording,roomRentCap,sumInsured,exemptions, csr)
    }
    fun createPolicy()
    {
        viewModel.createPolicy(getNewPolicy())
        viewModel.result.observe(this, {
            try {
                if (it.isSuccessful)
                    binding?.displayInfo?.text = it.body().toString()
                else {
                    val errorbody = it.errorBody()!!.string()
                    binding?.displayInfo?.text = errorbody
                    Log.e("errorbody", errorbody)
                }
            }
            catch(e:Exception)
            {
                Log.e("Exception",e.toString())
            }
        })
    }
}