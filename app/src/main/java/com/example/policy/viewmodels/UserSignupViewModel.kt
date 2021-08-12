package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.policy.models.User
import com.example.policy.models.signUpStatus
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


interface UserAPiService
{
    @POST("signup_user")
    suspend fun signUpUser(@Body newUser:User): signUpStatus
}

class UserSignupViewModel: ViewModel()
{
    var result = MutableLiveData<signUpStatus>()
    val url = "http://localhost:3001"
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(url).build()
    val service: UserAPiService = retrofit.create(UserAPiService::class.java)
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