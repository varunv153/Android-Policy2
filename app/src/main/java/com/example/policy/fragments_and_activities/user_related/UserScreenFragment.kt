package com.example.policy.fragments_and_activities.user_related

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.policy.R
import com.example.policy.databinding.FragmentUserScreenBinding

class UserScreenFragment : Fragment()
{
    private var binding: FragmentUserScreenBinding? = null
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        binding = FragmentUserScreenBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.userScreenFragment = this
    }
    fun renderViewPolicies()
    {
        Log.e("tag","user view policy")
        findNavController().navigate(R.id.action_userScreenFragment_to_viewPoliciesFragment)
    }
    fun renderBuyPolicy()
    {
        Log.e("tag","user buy policy")
        findNavController().navigate(R.id.action_userScreenFragment_to_buyPolicyFragment)
    }
}