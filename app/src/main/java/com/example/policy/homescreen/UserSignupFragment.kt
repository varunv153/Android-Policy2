package com.example.policy.homescreen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.policy.R
import com.example.policy.databinding.FragmentMainScreenBinding
import com.example.policy.databinding.FragmentUserSignupBinding
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.lang.Exception


data class signUpStatus(var signup_status:String)
data class User( var email:String, var password:String, var name:String, var phoneno:String )
class UserSignupFragment : Fragment()
{
    private var binding: FragmentUserSignupBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        binding = FragmentUserSignupBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.userSignupFragment = this
    }
    fun signupUser()
    {
        var viewModel = ViewModelProvider(this).get(UserSignupViewModel::class.java)

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


interface UserAPiService
{
    @POST("signup_user")
    suspend fun signUpUser(@Body newUser:User):signUpStatus
}
class UserSignupViewModel: ViewModel()
{
    var result = MutableLiveData<signUpStatus>()
    val url = "http://localhost:3001"
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(url).build()
    val service:UserAPiService = retrofit.create(UserAPiService::class.java)
    fun createUser(newUser: User)
    {
        result.value = signUpStatus("hi")
        GlobalScope.launch{
            try
            {
                result.postValue(service.signUpUser(newUser))
            }
            catch (e: Exception)
            {
                Log.e("tag",e.toString())
            }
        }
    }
}