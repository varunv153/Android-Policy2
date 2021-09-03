package com.example.policy.fragments_and_activities.recyclerview_specific

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.policy.databinding.FragmentDetailsPolicyBinding
import com.example.policy.viewmodels.MyAdapterViewModel

class DetailsPolicyFragment : Fragment()
{
    private var binding: FragmentDetailsPolicyBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    var companyName:String? = null
    var sumInsured:String? = null
    var policyID:String? = null
    var policyWording:String? = null
    var roomRentCap:String? = null
    var exemptions:String? = null
    var claimSettlementRatio:String? = null
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentDetailsPolicyBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.detailsPolicyFragment = this
        sumInsured = viewModel.policy?.suminsured.toString()
        companyName = viewModel.policy?.company_adminemail
        policyID = viewModel.policy?.id.toString()
        policyWording = viewModel.policy?.policywording
        roomRentCap = viewModel.policy?.roomrentcap.toString()
        exemptions = viewModel.policy?.exemptions
        claimSettlementRatio = viewModel.policy?.claim_settlement_ratio.toString()
    }
}