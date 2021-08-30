package com.example.policy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.policy.databinding.FragmentDetailsPolicyBinding

class DetailsPolicyFragment : Fragment()
{
    private var binding: FragmentDetailsPolicyBinding? = null
    val viewModel: MyAdapterViewModel by activityViewModels()
    var companyName:String? = null
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentDetailsPolicyBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.detailsPolicyFragment = this
        companyName = viewModel.policy?.company_adminemail
    }
}