package com.example.policy.fragments_and_activities.homescreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.policy.databinding.FragmentUserSignupBinding
import com.example.policy.models.User
import com.example.policy.viewmodels.UserSignupViewModel


class UserSignupFragment : Fragment()
{
    private var binding: FragmentUserSignupBinding? = null
    private lateinit var viewModel:UserSignupViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        viewModel = ViewModelProvider(this).get(UserSignupViewModel::class.java)
        binding = FragmentUserSignupBinding.inflate(inflater,container,false)
        binding?.displayInfo?.text = viewModel.result.value.toString()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.userSignupFragment = this
    }
    private fun getUser():User
    {
        val email =  binding?.signupEmail?.text.toString()
        val password =  binding?.signupPassword?.text.toString()
        val name =  binding?.signupName?.text.toString()
        val phoneno =  binding?.signupPhone?.text.toString()
        return User(email,password,name,phoneno)
    }
    fun signupUser()
    {
        viewModel.createUser(getUser())
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