package com.example.policy.models

data class ClaimStatus(var Status:String)
data class NewClaim(var bondid:Int, var reason:String, var claim_amount:Int, var hospital_name:String, var city:String)
data class Claim(var id:Int, var bondid:Int, var reason:String, var claim_amount:Int, var hospital_name:String, var city:String, var claimstatus:String)