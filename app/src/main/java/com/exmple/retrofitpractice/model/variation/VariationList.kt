package com.exmple.retrofitpractice.model.variation

import com.google.gson.annotations.SerializedName

data class VariationList(
    @SerializedName("variations") val list: List<VariationData>
)
