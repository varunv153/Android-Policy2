package com.example.policy.api

import com.example.policy.models.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CompanyAPIService
{
    @POST("signup_company")
    suspend fun signUpCompany(@Body newCompany: Company): Response<signUpStatus>
    @POST("login_company")
    suspend fun loginCompany(@Body newCompany: Company): Response<loginStatus>
    @POST("createpolicy")
    suspend fun createPolicy(@Body newPolicy: NewPolicy): Response<policyStatus>
    @GET("view_policies_of_my_company")
    suspend fun viewPoliciesOfCompany(): Response<MutableList<Policy>>
}