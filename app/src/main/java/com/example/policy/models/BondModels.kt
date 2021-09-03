package com.example.policy.models

data class BondStatus(var Purchase_Status:String)
data class NewBond(var policyid:Int, var policyholdername:String, var policyholderage:Int, var policyage:Int, var preexistingdiseases:String)
data class Bond(var id:Int, var useremail:String, var policyid:Int, var policyholdername:String, var policyholderage:Int, var policyage:Int, var preexistingdiseases:String, var premium:Int)