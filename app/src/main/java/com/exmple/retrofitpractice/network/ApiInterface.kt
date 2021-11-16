package com.exmple.retrofitpractice.network

import com.exmple.retrofitpractice.model.ServerResponse
import com.exmple.retrofitpractice.model.SignupSuccRsp
import com.exmple.retrofitpractice.model.SignupUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
    @GET("/json")//Here, `json` is the PATH PARAMETER
    fun getMyIp(): Call<ServerResponse?>?

    @POST("/api/accounts/v1/signup/")
    fun signupUser(@Body signupUser: SignupUser): Call<SignupSuccRsp>
}

