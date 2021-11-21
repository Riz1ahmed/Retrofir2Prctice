package com.exmple.retrofitpractice.model.shop

import com.google.gson.annotations.SerializedName

data class ShopData(
    @SerializedName("title") private val title: String,
    @SerializedName("address") private val address: String,
    @SerializedName("vat") private val vat: Float
)
