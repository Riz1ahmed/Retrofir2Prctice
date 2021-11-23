package com.exmple.retrofitpractice.model.variation

import com.google.gson.annotations.SerializedName

data class VariationData(
    @SerializedName("sku") val sku: String,
    @SerializedName("attributes") val attributes: String,
    @SerializedName("regular_price") val regularPrice: String,
    @SerializedName("selling_price") val sellingPrice: String,
    @SerializedName("product") val product: Int,
    @SerializedName("image") val image: Int
)
