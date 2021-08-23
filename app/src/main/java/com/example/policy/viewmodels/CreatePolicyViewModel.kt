package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.NewPolicy
import com.example.policy.models.User
import com.example.policy.models.loginStatus
import com.example.policy.models.policyStatus
import com.example.policy.repository.CompanyRepository
import com.example.policy.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CreatePolicyViewModel : ViewModel()
{
    private var repository = CompanyRepository()
    var result = MutableLiveData<Response<policyStatus>>()
    fun createPolicy(newPolicy: NewPolicy)
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.createPolicy(newPolicy)
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}