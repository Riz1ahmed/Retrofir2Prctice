package com.exmple.retrofitpractice.model.order

import com.google.gson.annotations.SerializedName

data class Sale(
    /**Currently it customer name*/
    @SerializedName("customer_contact_no") var customerId: String,
    @SerializedName("conductor") var seller: Int = 0, //As till not add in server
    /**Please use it using methods*/
    @SerializedName("sale_items") val saleItems: ArrayList<SaleItemData>,
    @SerializedName("shop_discount") val discount: Float,
    @SerializedName("payment_type") val paymentMethod: String,// PaymentMethodEnum,
    @SerializedName("due") val due: Int = 0
) {
    /**getSaleItems() name ambiguous. so used get word at last*/
    fun saleItemsGet() = saleItems.toList()
    fun deleteSaleItem(position: Int) =
        if (saleItems.size > position) deleteSaleItem(saleItems[position])
        else false

    fun deleteSaleItem(saleItem: SaleItemData): Boolean {
        return if (saleItems.contains(saleItem)) {
            /**Calculate subtotal*/
            /*var sp: Float = subTotal
            sp -= saleItem.totalPrice
            subTotal = sp*/
            /**Add item*/
            saleItems.remove(saleItem)
            true
        } else false
    }

    /**
     * If this item already exist then just replace the item.
     * Old Item will be remove. So please make sure before call this method
     * you calculated old data quantity.
     */
    fun addOrReplaceItem(saleItem: SaleItemData) {
        saleItems.indexOfFirst { it.stockId == saleItem.stockId }.let { idx ->
            if (idx == -1) {
                /**Calculate subtotal*/
                /*var sp: Float = subTotal
                sp += saleItem.totalPrice
                subTotal = sp*/
                /**Add item*/
                saleItems.add(saleItem)
            } else {
                /**Calculate subtotal*/
                /*var sp: Float = subTotal
                sp -= saleItems[idx].unitPrice * saleItems[idx].quantity
                sp += saleItem.totalPrice
                subTotal = sp*/
                /**Update item qty*/
                saleItems[idx].quantity = saleItem.quantity
            }
        }
        //_subTotal = null//So that calculate again.
    }

    /**
     * If this item already exist then just add the quantity value
     * with the old data quantity.
     */
    fun addOrUpdateQtyItem(saleItem: SaleItemData) {
        saleItems.indexOfFirst { it.stockId == saleItem.stockId }.let { idx ->
            if (idx == -1) saleItems.add(saleItem)
            else saleItems[idx].quantity += saleItem.quantity
        }
    }

    /**totalPrice Of saleItems*/
    var subTotal: Float = 0.0f
        get() {
            var total = 0f
            saleItems.forEach { total += it.totalPrice }
            return total
        }
}

