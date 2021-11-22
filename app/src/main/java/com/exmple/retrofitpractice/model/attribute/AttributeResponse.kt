package com.exmple.retrofitpractice.model.attribute

import com.google.gson.annotations.SerializedName

data class AttributeResponse(
    @SerializedName("message") val message: String
)
