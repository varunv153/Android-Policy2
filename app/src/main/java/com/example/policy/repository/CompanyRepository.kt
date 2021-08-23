package com.example.policy.repository

import com.example.policy.api.RetrofitInstance
import com.example.policy.models.*
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
    suspend fun createPolicy(newPolicy: NewPolicy): Response<policyStatus>
    {
        return RetrofitInstance.companyAPIService.createPolicy(newPolicy)
    }
}