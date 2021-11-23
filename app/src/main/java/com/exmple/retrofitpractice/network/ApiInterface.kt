package com.exmple.retrofitpractice.network

import com.exmple.retrofitpractice.model.attribute.AttributeListData
import com.exmple.retrofitpractice.model.attribute.AttributeResponse
import com.exmple.retrofitpractice.model.order.Invoice
import com.exmple.retrofitpractice.model.order.Sale
import com.exmple.retrofitpractice.model.product.ProductData
import com.exmple.retrofitpractice.model.server.ServerResponse
import com.exmple.retrofitpractice.model.shop.ShopCreateSuccResp
import com.exmple.retrofitpractice.model.shop.ShopData
import com.exmple.retrofitpractice.model.signin.SignInUser
import com.exmple.retrofitpractice.model.signin.SigninSuccRsp
import com.exmple.retrofitpractice.model.signup.SignupSuccRsp
import com.exmple.retrofitpractice.model.signup.SignupUser
import com.exmple.retrofitpractice.model.stock.PurchaseData
import com.exmple.retrofitpractice.model.variation.VariationList
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
    suspend fun createProduct(@Body productData: ProductData): Response<ProductData>

    @POST("/api/inventory/v1/purchases/")
    suspend fun addPurchase(@Body purchaseData: PurchaseData): Response<PurchaseData>

    @POST("/api/inventory/v1/attributes/")
    suspend fun addAttribute(@Body attributeListData: AttributeListData): Response<AttributeResponse>

    @POST("/api/inventory/v1/variations/")
    suspend fun addVariation(@Body variationList: VariationList): Response<AttributeResponse>

    @POST("/api/sale/v1/sales/")
    suspend fun createOrder(@Body sale: Sale): Response<Invoice>


}

