package com.example.policy.repository

import com.example.policy.api.RetrofitInstance
import com.example.policy.models.Policy
import com.example.policy.models.User
import com.example.policy.models.loginStatus
import com.example.policy.models.signUpStatus
import retrofit2.Response

class UserRepository
{
    suspend fun signUpUser(newUser: User): Response<signUpStatus>
    {
        return RetrofitInstance.userAPIService.signUpUser(newUser)
    }
    suspend fun loginUser(newUser: User): Response<loginStatus>
    {
        return RetrofitInstance.userAPIService.loginUser(newUser)
    }
    suspend fun viewPolicies():Response<MutableList<Policy>>
    {
        return RetrofitInstance.userAPIService.viewPolicies()
    }
}