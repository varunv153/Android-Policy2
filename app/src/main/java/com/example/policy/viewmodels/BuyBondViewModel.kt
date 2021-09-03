package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.BondStatus
import com.example.policy.models.NewBond
import com.example.policy.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class BuyBondViewModel : ViewModel()
{
    private var repository = UserRepository()
    var result = MutableLiveData<Response<BondStatus>>()
    fun createBond(newBond: NewBond)
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.buyPolicy(newBond)
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}