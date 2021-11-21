package com.exmple.retrofitpractice.model.server

import com.google.gson.annotations.SerializedName


data class ServerResponse(
    @SerializedName("ip")          var ip: String?,
    @SerializedName("ip_decimal")  var ipDecimal: Int?,
    @SerializedName("country")     var country: String?,
    @SerializedName("country_iso") var countryIso: String?,
    @SerializedName("city")        var city: String?,
    @SerializedName("hostname")    var hostname: String?
)