package com.example.policy.api

import com.example.policy.models.*
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
    @POST("buy")
    suspend fun buyPolicy(@Body newBond: NewBond): Response<BondStatus>
    @GET("viewmypolicies")
    suspend fun viewMyBonds(): Response<MutableList<Bond>>
    @POST("claimpolicy")
    suspend fun createClaim(@Body newClaim: NewClaim): Response<ClaimStatus>
}