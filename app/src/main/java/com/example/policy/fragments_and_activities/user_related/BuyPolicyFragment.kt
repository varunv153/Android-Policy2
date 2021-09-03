package com.example.policy.fragments_and_activities.user_related

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.policy.databinding.FragmentBuyPolicyBinding
import com.example.policy.models.NewBond
import com.example.policy.viewmodels.BuyBondViewModel

class BuyPolicyFragment : Fragment()
{
    private var binding: FragmentBuyPolicyBinding? = null
    private lateinit var viewModel: BuyBondViewModel
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        viewModel = ViewModelProvider(this).get(BuyBondViewModel::class.java)
        binding = FragmentBuyPolicyBinding.inflate(inflater,container,false)
        binding?.displayInfo?.text = viewModel.result.value.toString()
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.buyPolicyFragment = this
    }
    private fun getNewBond(): NewBond
    {
        val policyID =  binding?.policyID?.text.toString().toInt()
        val policyHolderName =  binding?.policyHolderName?.text.toString()
        val policyHolderAge =  binding?.policyHolderAge?.text.toString().toInt()
        val policyAge =  binding?.policyAge?.text.toString().toInt()
        val preExistingDiseases =  binding?.preDiseases?.text.toString()
        return NewBond(policyID, policyHolderName, policyHolderAge, policyAge, preExistingDiseases)
    }
    fun createBond()
    {
        viewModel.createBond(getNewBond())
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