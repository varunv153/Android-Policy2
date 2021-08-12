package com.example.policy.fragments_and_activities.homescreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.policy.R
import com.example.policy.databinding.FragmentMainScreenBinding

class MainScreenFragment : Fragment()
{
    private var binding: FragmentMainScreenBinding ? = null
    override fun onCreateView( inflater: LayoutInflater,  container: ViewGroup?,  savedInstanceState: Bundle? ): View?
    {
        binding = FragmentMainScreenBinding.inflate(inflater,container,false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        binding?.mainScreenFragment = this
    }
    fun renderSignupCompany()
    {
        Log.e("tag","companysignup")
        findNavController().navigate(R.id.action_mainScreenFragment_to_companySignupFragment)
    }
    fun renderLoginCompany()
    {
        Log.e("tag","companylogin")
        findNavController().navigate(R.id.action_mainScreenFragment_to_companyLoginFragment)
    }

    fun renderSignupUser()
    {
        Log.e("tag","usersingup")
        findNavController().navigate(R.id.action_mainScreenFragment_to_userSignupFragment)
    }
    fun renderLoginUser()
    {
        Log.e("tag","userlogin")
        findNavController().navigate(R.id.action_mainScreenFragment_to_userLoginFragment)
    }
}