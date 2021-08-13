package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.api.RetrofitInstance.moshi
import com.example.policy.models.User
import com.example.policy.models.signUpStatus
import com.example.policy.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class UserSignupViewModel: ViewModel()
{
    private var repository = UserRepository()
    var result = MutableLiveData<Response<signUpStatus>>()
    fun createUser(newUser: User)
    {
        viewModelScope.launch{
            try
            {
                var a =  repository.signUpUser(newUser)
                result.value = a
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}