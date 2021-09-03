package com.example.policy.fragments_and_activities.user_related

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.policy.databinding.FragmentCreateClaimBinding
import com.example.policy.models.NewClaim
import com.example.policy.viewmodels.CreateClaimViewModel

class CreateClaimFragment : Fragment()
{
    private var binding: FragmentCreateClaimBinding? = null
    private lateinit var viewModel: CreateClaimViewModel
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        viewModel = ViewModelProvider(this).get(CreateClaimViewModel::class.java)
        binding = FragmentCreateClaimBinding.inflate(inflater,container,false)
        binding?.displayInfo?.text = viewModel.result.value.toString()
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.createClaimFragment = this
    }
    private fun getNewClaim(): NewClaim
    {
        val bondID =  binding?.bondID?.text.toString().toInt()
        val reason =  binding?.reason?.text.toString()
        val amount =  binding?.claimAmount?.text.toString().toInt()
        val hospitalName =  binding?.hospitalName?.text.toString()
        val cityName =  binding?.cityName?.text.toString()
        return NewClaim(bondID, reason, amount, hospitalName, cityName)
    }
    fun createClaim()
    {
        viewModel.createClaim(getNewClaim())
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