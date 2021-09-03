package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.Claim
import com.example.policy.repository.CompanyRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewClaimsCompanyViewModel: ViewModel()
{
    private var repository = CompanyRepository()
    var result = MutableLiveData<Response<MutableList<Claim>>>()
    fun viewClaimsOfCompany()
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.viewClaimsOfCompany()
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}