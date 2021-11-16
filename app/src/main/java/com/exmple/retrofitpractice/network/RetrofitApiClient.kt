package com.exmple.retrofitpractice.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApiClient {
    companion object {
        //private const val BASE_URL = "https://ifconfig.co"
        private const val BASE_URL = "https://shop-manager.liilab.com"
        private var retrofit: Retrofit? = null
        private val gson: Gson = GsonBuilder().setLenient().create()

        fun getClient(): Retrofit {
            if (retrofit == null) {
                synchronized(RetrofitApiClient::class.java) {
                    if (retrofit == null) {
                        retrofit = Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build()
                    }
                }
            }
            return retrofit!!
        }
    }


}