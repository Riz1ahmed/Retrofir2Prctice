package com.exmple.retrofitpractice.network

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.liilab.moneymaker.data.retrofit.AuthInterceptor
import com.liilab.moneymaker.data.retrofit.NetworkInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApiClient {
    companion object {
        //private const val BASE_URL = "https://ifconfig.co"
        private const val BASE_URL = "https://shop-manager.liilab.com"
        const val TIME_OUT: Long = 60L

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


        private var apiInterface: ApiInterface? = null

        fun getApiInterface(context: Context): ApiInterface {
            val authInterceptor = AuthInterceptor(context)
            val networkInterceptor = NetworkInterceptor(context)

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(authInterceptor)
                .addInterceptor(networkInterceptor)
                .build()

            val gson = GsonBuilder().create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
                .create(ApiInterface::class.java)
        }
    }
}