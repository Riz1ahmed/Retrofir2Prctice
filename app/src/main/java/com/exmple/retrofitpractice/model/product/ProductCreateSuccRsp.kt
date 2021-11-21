package com.exmple.retrofitpractice.model.product

import com.google.gson.annotations.SerializedName

data class ProductCreateSuccRsp(
    @SerializedName("id") val id: Int,
    @SerializedName("created_date") val created_date: String,
    @SerializedName("modified_date") val modified_date: String,
    @SerializedName("sku") var sku: String,
    @SerializedName("brand") var brand: String,
    @SerializedName("title") var title: String,
    @SerializedName("measurement") var measurement: String,//unitValue
    @SerializedName("tags") val tags: String,
    //var barcode: String,
    //var isManualBarcode: Boolean,
    @SerializedName("note") val note: String?,
    @SerializedName("unit") var unit: Int,  //unitType
    @SerializedName("shop") val shop: Int,
    @SerializedName("images") val images: List<Int>
)
