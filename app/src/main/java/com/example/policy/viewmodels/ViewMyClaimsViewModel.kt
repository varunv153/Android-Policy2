package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.Claim
import com.example.policy.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewMyClaimsViewModel: ViewModel()
{
    private var repository = UserRepository()
    var result = MutableLiveData<Response<MutableList<Claim>>>()
    fun viewMyClaims()
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.viewMyClaims()
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}