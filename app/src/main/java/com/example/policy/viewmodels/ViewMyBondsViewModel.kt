package com.example.policy.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.policy.models.Bond
import com.example.policy.repository.UserRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewMyBondsViewModel: ViewModel()
{
    private var repository = UserRepository()
    var result = MutableLiveData<Response<MutableList<Bond>>>()
    fun viewMyBonds()
    {
        viewModelScope.launch{
            try
            {
                result.value = repository.viewMyBonds()
            }
            catch (e: Exception)
            {
                Log.e("exception", e.toString())
            }
        }
    }
}