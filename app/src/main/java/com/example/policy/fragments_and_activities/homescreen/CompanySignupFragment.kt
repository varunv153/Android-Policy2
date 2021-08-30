package com.example.policy.fragments_and_activities.homescreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.policy.databinding.FragmentCompanySignupBinding
import com.example.policy.models.Company
import com.example.policy.viewmodels.CompanySignupViewModel

class CompanySignupFragment : Fragment()
{
    private var binding: FragmentCompanySignupBinding? = null
    private lateinit var viewModel: CompanySignupViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        viewModel = ViewModelProvider(this).get(CompanySignupViewModel::class.java)
        binding = FragmentCompanySignupBinding.inflate(inflater,container,false)
        binding?.displayInfo?.text = viewModel.result.value.toString()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.companySignupFragment = this
    }
    private fun getCompany(): Company
    {
        val email =  binding?.signupEmail?.text.toString()
        val password =  binding?.signupPassword?.text.toString()
        val name =  binding?.signupName?.text.toString()
        return Company(email,password,name)
    }
    fun signupCompany()
    {
        viewModel.createCompany(getCompany())
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