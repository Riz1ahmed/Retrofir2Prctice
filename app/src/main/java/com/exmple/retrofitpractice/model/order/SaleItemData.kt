package com.exmple.retrofitpractice.model.order

import com.google.gson.annotations.SerializedName

data class SaleItemData(
    @SerializedName("variation") val variation: String, //productBarcode
    @SerializedName("quantity") var quantity: Int,
    @SerializedName("product_discount") val discount: Float,

    //Extra response data from server
    @SerializedName("id") val id: Int,
    @SerializedName("unit_price") val unitPrice: Float,
    @SerializedName("sale") val sale: Int,//Invoice/Order ID

    val stockId: Long = 0//currently unusable to server but app.
) {
    val totalPrice: Float
        get() = unitPrice * quantity - discount
}