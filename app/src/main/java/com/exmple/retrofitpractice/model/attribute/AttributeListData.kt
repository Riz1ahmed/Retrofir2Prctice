package com.exmple.retrofitpractice.model.attribute

import com.google.gson.annotations.SerializedName

data class AttributeListData(
    @SerializedName("attributes") val attributes: List<AttributeData>
)
