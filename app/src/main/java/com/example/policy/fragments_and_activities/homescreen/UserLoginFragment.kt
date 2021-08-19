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
import com.example.policy.databinding.FragmentUserLoginBinding
import com.example.policy.models.User
import com.example.policy.viewmodels.UserLoginViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class UserLoginFragment : Fragment()
{
    private var binding: FragmentUserLoginBinding? = null
    private lateinit var viewModel: UserLoginViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        viewModel = ViewModelProvider(this).get(UserLoginViewModel::class.java)
        binding = FragmentUserLoginBinding.inflate(inflater,container,false)
        binding?.displayInfo?.text = viewModel.result.value.toString()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.userLoginFragment = this
    }
    private fun getUser(): User
    {
        val email =  binding?.loginEmail?.text.toString()
        val password =  binding?.loginPassword?.text.toString()
        val name =  ""
        val phoneno =  ""
        return User(email,password,name,phoneno)
    }
    fun loginUser()
    {
        viewModel.loginUser(getUser())
        viewModel.result.observe(this, {
            try {
                if (it.isSuccessful) {
                    binding?.displayInfo?.text = it.body().toString()
                    renderUserScreen()
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
    private fun renderUserScreen()
    {
        Log.e("tag", "companyscreen")
        findNavController().navigate(R.id.action_userLoginFragment_to_userScreenFragment)
    }
}