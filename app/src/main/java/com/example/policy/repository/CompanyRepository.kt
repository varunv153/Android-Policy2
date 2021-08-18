package com.example.policy.repository

import com.example.policy.api.RetrofitInstance
import com.example.policy.models.Company
import com.example.policy.models.loginStatus
import com.example.policy.models.signUpStatus
import retrofit2.Response

class CompanyRepository
{
    suspend fun signUpCompany(newCompany: Company): Response<signUpStatus>
    {
        return RetrofitInstance.companyAPIService.signUpCompany(newCompany)
    }
    suspend fun loginCompany(newCompany: Company): Response<loginStatus>
    {
        return RetrofitInstance.companyAPIService.loginCompany(newCompany)
    }
}