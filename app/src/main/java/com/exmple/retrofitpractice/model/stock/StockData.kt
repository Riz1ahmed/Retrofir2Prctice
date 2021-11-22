package com.exmple.retrofitpractice.model.stock

data class StockData(
    var id: Long = 0L, //Please do not change it from zero.
    val productBarcode: String,
    var quantity: Int,
    val buyingPrice: Float?,
    val sellingPrice: Float,
    val expireDate: String? = null// 25/08/2021
)
