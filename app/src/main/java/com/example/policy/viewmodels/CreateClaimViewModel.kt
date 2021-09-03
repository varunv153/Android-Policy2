package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.ClaimStatus
import com.example.policy.models.NewClaim
import com.example.policy.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CreateClaimViewModel : ViewModel()
{
    private var repository = UserRepository()
    var result = MutableLiveData<Response<ClaimStatus>>()
    fun createClaim(newClaim: NewClaim)
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.createClaim(newClaim)
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}