package com.exmple.retrofitpractice.model.stock

import com.google.gson.annotations.SerializedName

data class PurchaseData(
    //@SerializedName("id") var id: Long,
    val productBarcode: String,//Product data id
    @SerializedName("quantity") var quantity: Int,
    @SerializedName("buying_price") val buyingPrice: Float,
    val sellingPrice: Float,
    @SerializedName("exp_date") val expDate: String?=null, //28.09.2021
    @SerializedName("mfg_date") val mfgDate: String?=null, //28.09.2021
    @SerializedName("dealer_name") val dealerName:String,
    @SerializedName("dealer_contact") val dealerContact:String,
    val note: String?
)