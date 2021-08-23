package com.example.policy.models

data class policyStatus(var Policy_Status:String)
data class NewPolicy(var policywording:String, var roomrentcap:Int, var suminsured:Int, var exemptions:String, var claim_settlement_ratio:Double)
data class Policy(var id:Int, var policywording:String, var roomrentcap:Int, var suminsured:Int, var exemptions:String, var claim_settlement_ratio:Double)