package com.exmple.retrofitpractice.model.stock

import com.google.gson.annotations.SerializedName

data class PurchaseData(
    //@SerializedName("id") var id: Long,
    @SerializedName("quantity") var quantity: Int,
    @SerializedName("buying_price") val buyingPrice: Float,
    //val sellingPrice: Float,
    @SerializedName("exp_date") val expDate: String?=null, //28.09.2021
    @SerializedName("mfg_date") val mfgDate: String?=null, //28.09.2021
    @SerializedName("dealer_name") val dealerName:String?=null,
    @SerializedName("dealer_contact") val dealerContact:String?=null,
    @SerializedName("variation") val variation: Int,//Product data id for one2one
    @SerializedName("conductor") val conductor: Int?=null,//Product data id for one2one
    //@SerializedName("note") val note: String?=null,

    //Extra response data from server
    @SerializedName("modified_date") private val modifiedDate: String?=null,
    @SerializedName("created_date") private val createdDate: String?=null,
)