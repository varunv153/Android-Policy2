package com.example.policy.fragments_and_activities.homescreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.example.policy.databinding.FragmentUserSignupBinding
import com.example.policy.models.User
import com.example.policy.models.signUpStatus
import com.example.policy.viewmodels.UserSignupViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.lang.Exception


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
    fun signupUser()
    {

        var email =  binding?.signupEmail?.text.toString()
        var password =  binding?.signupPassword?.text.toString()
        var name =  binding?.signupName?.text.toString()
        var phoneno =  binding?.signupPhone?.text.toString()

        viewModel.createUser(User(email,password,name,phoneno))
        viewModel.result.observe(this, Observer {
            binding?.displayInfo?.text = it.toString()
        })
    }
}

