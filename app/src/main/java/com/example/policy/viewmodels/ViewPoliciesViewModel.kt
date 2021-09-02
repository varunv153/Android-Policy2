package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.Policy
import com.example.policy.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewPoliciesViewModel: ViewModel()
{
    private var repository = UserRepository()
    var result = MutableLiveData<Response<MutableList<Policy>>>()
    fun viewPolicies()
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.viewPolicies()
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}