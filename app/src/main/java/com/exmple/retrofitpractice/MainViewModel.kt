package com.exmple.retrofitpractice

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.exmple.retrofitpractice.network.RetrofitApiClient

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val retrofitApiClient = RetrofitApiClient.getApiInterface(application)

    /*fun createShop() = liveData<ShopCreateSuccResp> {
        emit(retrofitApiClient.createShop())
    }*/

    /*fun getUsers() = liveData<Resource<Nothing>>(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = retrofitApiClient.signInUser("")))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }*/
}