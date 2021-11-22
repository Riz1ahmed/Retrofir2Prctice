package com.exmple.retrofitpractice.model.variation

import com.exmple.retrofitpractice.model.attribute.AttributeData
import com.google.gson.annotations.SerializedName

data class VariationList(
    @SerializedName("variations") val list: List<AttributeData>
)
