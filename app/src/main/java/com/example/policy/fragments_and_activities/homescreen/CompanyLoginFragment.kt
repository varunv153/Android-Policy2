package com.example.policy.fragments_and_activities.homescreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.policy.R
import com.example.policy.databinding.FragmentCompanyLoginBinding
import com.example.policy.fragments_and_activities.cookie
import com.example.policy.models.Company
import com.example.policy.viewmodels.CompanyLoginViewModel
import kotlin.reflect.KClass

class CompanyLoginFragment : Fragment()
{
    private var binding: FragmentCompanyLoginBinding? = null
    private lateinit var viewModel: CompanyLoginViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        viewModel = ViewModelProvider(this).get(CompanyLoginViewModel::class.java)
        binding = FragmentCompanyLoginBinding.inflate(inflater,container,false)
        binding?.displayInfo?.text = viewModel.result.value.toString()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.companyLoginFragment = this
    }
    private fun getCompany(): Company
    {
        val email =  binding?.loginEmail?.text.toString()
        val password =  binding?.loginPassword?.text.toString()
        val name =  ""
        return Company(email = email, password = password, company_name = name)
    }
    fun loginCompany()
    {
        viewModel.loginCompany(getCompany())
        viewModel.result.observe(this, {
            try {
                if (it.isSuccessful) {
                    binding?.displayInfo?.text = it.body().toString()
                    cookie = it.headers()["Set-Cookie"]!!.split("; ")[0].split("=")[1]
                    renderCompanyScreen()
                }
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
    private fun renderCompanyScreen()
    {
        Log.e("tag", "companyscreen")
        findNavController().navigate(R.id.action_companyLoginFragment_to_companyScreenFragment)
    }
}