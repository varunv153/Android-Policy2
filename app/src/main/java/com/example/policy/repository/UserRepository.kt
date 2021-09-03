package com.example.policy.repository

import com.example.policy.api.RetrofitInstance
import com.example.policy.models.*
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
    suspend fun buyPolicy(newBond: NewBond): Response<BondStatus>
    {
        return RetrofitInstance.userAPIService.buyPolicy(newBond)
    }
    suspend fun viewMyBonds(): Response<MutableList<Bond>>
    {
        return RetrofitInstance.userAPIService.viewMyBonds()
    }
    suspend fun createClaim(newClaim: NewClaim): Response<ClaimStatus>
    {
        return RetrofitInstance.userAPIService.createClaim(newClaim)
    }
    suspend fun viewMyClaims(): Response<MutableList<Claim>>
    {
        return RetrofitInstance.userAPIService.viewMyClaims()
    }
}