package com.example.policy.api

import com.example.policy.models.Company
import com.example.policy.models.User
import com.example.policy.models.loginStatus
import com.example.policy.models.signUpStatus
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CompanyAPIService
{
    @POST("signup_company")
    suspend fun signUpCompany(@Body newCompany: Company): Response<signUpStatus>
    @POST("login_company")
    suspend fun loginCompany(@Body newCompany: Company): Response<loginStatus>
}