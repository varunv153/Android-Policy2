package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.Company
import com.example.policy.models.signUpStatus
import com.example.policy.repository.CompanyRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CompanySignupViewModel: ViewModel()
{
    private var repository = CompanyRepository()
    var result = MutableLiveData<Response<signUpStatus>>()
    fun createCompany(newCompany: Company)
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.signUpCompany(newCompany)
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}