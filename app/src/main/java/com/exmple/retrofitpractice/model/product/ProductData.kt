package com.exmple.retrofitpractice.model.product

import com.google.gson.annotations.SerializedName

data class ProductData(
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

/*
@Entity(tableName = "product_table")
data class ProductData(
    var title: String,
    @PrimaryKey var barcode: String,
    var unit: String,
    var isManualBarcode: Boolean,
    val note: String?,
    val tags: ArrayList<String>
)
*/
