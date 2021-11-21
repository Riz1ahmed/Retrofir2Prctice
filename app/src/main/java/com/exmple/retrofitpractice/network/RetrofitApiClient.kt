package com.exmple.retrofitpractice.network

import android.content.Context
import com.exmple.retrofitpractice.AuthInterceptor
import com.google.gson.GsonBuilder
import com.liilab.moneymaker.data.retrofit.NetworkInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApiClient {
    companion object {
        //private const val BASE_URL = "https://ifconfig.co"
        private const val BASE_URL = "https://shop-manager.liilab.com"
        private const val TIME_OUT: Long = 60L

        /*private var retrofit: Retrofit? = null
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
        }*/

        private var apiInterface: ApiInterface? = null
        fun getApiInterface(context: Context): ApiInterface {
            if (apiInterface == null) {
                synchronized(RetrofitApiClient::class.java) {
                    val okHttpClient = OkHttpClient.Builder()
                        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                        .addInterceptor(AuthInterceptor(context))
                        .addInterceptor(NetworkInterceptor(context))
                        .build()

                    val gson = GsonBuilder().create()
                    if (apiInterface == null) {
                        apiInterface = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(okHttpClient)
                            .build()
                            .create(ApiInterface::class.java)
                    }
                }
            }
            return apiInterface!!
        }
    }
}