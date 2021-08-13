package com.example.policy.repository

import com.example.policy.api.RetrofitInstance
import com.example.policy.models.User
import com.example.policy.models.signUpStatus
import retrofit2.Response

class UserRepository
{
    suspend fun signUpUser(newUser: User): Response<signUpStatus>
    {
        return RetrofitInstance.service.signUpUser(newUser)
    }
}