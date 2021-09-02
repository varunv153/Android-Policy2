package com.example.policy.api

import com.example.policy.models.Policy
import com.example.policy.models.User
import com.example.policy.models.loginStatus
import com.example.policy.models.signUpStatus
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserAPIService
{
    @POST("signup_user")
    suspend fun signUpUser(@Body newUser: User): Response<signUpStatus>
    @POST("login_user")
    suspend fun loginUser(@Body newUser: User): Response<loginStatus>
    @GET("policies")
    suspend fun viewPolicies(): Response<MutableList<Policy>>
}