package com.exmple.retrofitpractice.network

import com.exmple.retrofitpractice.model.product.ProductCreateSuccRsp
import com.exmple.retrofitpractice.model.product.ProductData
import com.exmple.retrofitpractice.model.server.ServerResponse
import com.exmple.retrofitpractice.model.shop.ShopCreateSuccResp
import com.exmple.retrofitpractice.model.shop.ShopData
import com.exmple.retrofitpractice.model.signin.SignInUser
import com.exmple.retrofitpractice.model.signin.SigninSuccRsp
import com.exmple.retrofitpractice.model.signup.SignupSuccRsp
import com.exmple.retrofitpractice.model.signup.SignupUser
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
    @GET("/json")//Here, `json` is the PATH PARAMETER
    suspend fun getMyIp(): Response<ServerResponse?>?

    @POST("/api/accounts/v1/signup/")
    suspend fun signupUser(@Body signupUser: SignupUser): Response<SignupSuccRsp>

    @POST("/api/accounts/v1/signin/")
    suspend fun signInUser(@Body signInUser: SignInUser): Response<SigninSuccRsp>

    @POST("/api/shop/v1/shops/")
    suspend fun createShop(@Body shopData: ShopData): Response<ShopCreateSuccResp>

    @POST("/api/inventory/v1/products/")
    suspend fun createProduct(@Body productData: ProductData): Response<ProductCreateSuccRsp>

    @POST("/api/inventory/v1/products/")
    suspend fun createStock(@Body productData: ProductData): Response<ProductCreateSuccRsp>
}

