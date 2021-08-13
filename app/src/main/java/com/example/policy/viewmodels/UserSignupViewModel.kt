package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.api.RetrofitInstance.service
import com.example.policy.models.User
import com.example.policy.models.signUpStatus
import kotlinx.coroutines.launch

class UserSignupViewModel: ViewModel()
{
    var result = MutableLiveData<signUpStatus>()
    fun createUser(newUser: User)
    {
        result.value = signUpStatus("hi")
        viewModelScope.launch{
            try
            {
                var res = service.signUpUser(newUser)
                result.postValue(res)
            }
            catch (e: Exception)
            {
                Log.e("tag", e.toString())
            }
        }
    }
}