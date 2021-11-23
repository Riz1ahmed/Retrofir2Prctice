package com.exmple.retrofitpractice.model.order

import com.google.gson.annotations.SerializedName

data class Invoice(
    /**Currently it customer name*/
    @SerializedName("customer_contact_no") var customerId: String,
    @SerializedName("conductor") var seller: Int = 0, //As till not add in server
    /**Please use it using methods*/
    @SerializedName("sale_items") val saleItems: ArrayList<SaleItemData>,
    @SerializedName("shop_discount") val discount: Float,
    @SerializedName("payment_type") val paymentMethod: String,// PaymentMethodEnum,
    @SerializedName("due") val due: Int = 0,
    //val paymentState: PaymentStateEnum,
    //var invoiceStatusEnum: InvoiceStatusEnum,

    //Extra response data from server
    @SerializedName("modified_date") private val modifiedDate: String,
    @SerializedName("created_date") private val timeInMillis: String,//createdDate
    @SerializedName("id") var id: String,
    @SerializedName("vat") val vat: Float,
    @SerializedName("subtotal") val subtotal: Int,
    @SerializedName("employee") val employee:Int
) {
    //private var _subTotal = 0f
    /*val subTotal: Float
        get() {
            if (_subTotal == null) {
                var tp = 0f
                saleItems.forEach { tp += it.unitPrice * it.quantity }
                _subTotal = tp
            }
            return _subTotal!!
        }*/

    /**totalPrice Of saleItems*/
    var subTotal: Float = 0.0f
        get() {
            var total = 0f
            saleItems.forEach { total += it.totalPrice }
            return total
        }

    val totalPrice: Float
        get() = subTotal - discount + vat
}

