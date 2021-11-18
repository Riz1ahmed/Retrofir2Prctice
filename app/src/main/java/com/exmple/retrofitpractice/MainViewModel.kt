package com.exmple.retrofitpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import com.exmple.retrofitpractice.network.RetrofitApiClient
import com.exmple.retrofitpractice.using_corouitne.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val retrofitApiClient = RetrofitApiClient.getApiInterface(application)

    fun getUsers() = liveData<Resource<Nothing>>(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = retrofitApiClient.signInUser("")))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}