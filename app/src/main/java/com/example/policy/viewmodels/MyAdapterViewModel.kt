package com.example.policy.viewmodels

import androidx.lifecycle.ViewModel
import com.example.policy.models.Bond
import com.example.policy.models.Claim
import com.example.policy.models.Policy

class MyAdapterViewModel : ViewModel()
{
    var policy: Policy? = null
    var bond: Bond? = null
    var claim: Claim? = null
}