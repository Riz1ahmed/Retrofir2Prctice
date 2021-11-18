package com.exmple.retrofitpractice.model.shop

import com.exmple.retrofitpractice.model.UserInfo
import com.google.gson.annotations.SerializedName

data class ShopCreateSuccResp(
    @SerializedName("modified_date") private val modifiedDate: String,
    @SerializedName("created_date") private val createdDate: String,
    @SerializedName("id") private val id: String,
    @SerializedName("title") private val title: String,
    @SerializedName("address") private val address: String,
    @SerializedName("vat") private val vat: String,
    @SerializedName("owner") private val owner: UserInfo,
)
