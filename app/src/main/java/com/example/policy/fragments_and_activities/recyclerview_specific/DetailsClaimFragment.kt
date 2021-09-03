package com.example.policy.fragments_and_activities.recyclerview_specific

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.policy.databinding.FragmentDetailsClaimBinding
import com.example.policy.viewmodels.MyAdapterViewModel

class DetailsClaimFragment : Fragment()
{
    private var binding: FragmentDetailsClaimBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    var id:String? = null
    var bondID:String? = null
    var city:String? = null
    var claimAmount:String? = null
    var claimStatus:String? = null
    var reason:String? = null
    var hospitalName:String? = null

    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentDetailsClaimBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.detailsClaimFragment = this
        id = viewModel.claim?.id.toString()
        bondID = viewModel.claim?.bondid.toString()
        city = viewModel.claim?.city
        claimAmount = viewModel.claim?.claim_amount.toString()
        claimStatus = viewModel.claim?.claimstatus
        reason = viewModel.claim?.reason
        hospitalName = viewModel.claim?.hospital_name
    }
}