package com.exmple.retrofitpractice.model.shop

import com.google.gson.annotations.SerializedName

data class ShopCreateErrResp(
    @SerializedName("non_field_errors") val nonFieldErrors: List<String>?,
    @SerializedName("title") private val title: List<String>?,
    @SerializedName("address") private val address: List<String>?,
    @SerializedName("vat") private val vat: List<String>?,
)
