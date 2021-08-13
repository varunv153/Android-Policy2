package com.example.policy.repository

import com.example.policy.api.RetrofitInstance
import com.example.policy.models.User
import com.example.policy.models.signUpStatus

class UserRepository
{
    suspend fun signUpUser(newUser: User): signUpStatus
    {
        return RetrofitInstance.service.signUpUser(newUser)
    }
}