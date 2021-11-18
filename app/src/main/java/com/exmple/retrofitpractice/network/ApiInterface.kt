package com.exmple.retrofitpractice.network

import com.exmple.retrofitpractice.model.server.ServerResponse
import com.exmple.retrofitpractice.model.shop.ShopCreateSuccResp
import com.exmple.retrofitpractice.model.shop.ShopData
import com.exmple.retrofitpractice.model.signin.SignInUser
import com.exmple.retrofitpractice.model.signin.SigninSuccRsp
import com.exmple.retrofitpractice.model.signup.SignupSuccRsp
import com.exmple.retrofitpractice.model.signup.SignupUser
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
    @GET("/json")//Here, `json` is the PATH PARAMETER
    fun getMyIp(): Call<ServerResponse?>?

    @POST("/api/accounts/v1/signup/")
    fun signupUser(@Body signupUser: SignupUser): Call<SignupSuccRsp>

    @POST("/api/accounts/v1/signin/")
    fun signInUser(@Body signInUser: SignInUser): Call<SigninSuccRsp>

    @POST("/api/accounts/v1/shops/")
    fun createShop(@Body shopData: ShopData): Call<ShopCreateSuccResp>
}

