package com.example.policy.fragments_and_activities.user_related

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.policy.databinding.FragmentDetailsBondBinding
import com.example.policy.viewmodels.MyAdapterViewModel

class DetailsBondFragment : Fragment()
{
    private var binding: FragmentDetailsBondBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    var bondID:String? = null
    var policyID:String? = null
    var userEmail:String? = null
    var policyHolderName:String? = null
    var policyHolderAge:String? = null
    var policyAge:String? = null
    var preExistingDiseases:String? = null
    var premium:String? = null


    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentDetailsBondBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.detailsBondFragment = this
        bondID = viewModel.bond?.id.toString()
        policyID = viewModel.bond?.policyid.toString()
        userEmail = viewModel.bond?.useremail
        policyHolderName = viewModel.bond?.policyholdername
        policyHolderAge = viewModel.bond?.policyholderage.toString()
        policyAge = viewModel.bond?.policyage.toString()
        preExistingDiseases = viewModel.bond?.preexistingdiseases
        premium = viewModel.bond?.premium.toString()
    }
}