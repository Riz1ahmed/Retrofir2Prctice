package com.exmple.retrofitpractice.model.attribute

import com.google.gson.annotations.SerializedName

data class AttributeData(
    @SerializedName("product") val product: Int,
    @SerializedName("title") val title: String,
    @SerializedName("values") val values: String,
    @SerializedName("sort_weight") val sortWeight: Int,
)
