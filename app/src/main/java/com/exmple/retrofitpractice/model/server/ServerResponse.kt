package com.exmple.retrofitpractice.model.server

import com.google.gson.annotations.SerializedName


data class ServerResponse(
    @SerializedName("ip")          var ip: String?,
    @SerializedName("ip_decimal")  var ipDecimal: Int?,
    @SerializedName("country")     var country: String?,
    @SerializedName("country_iso") var countryIso: String?,
    @SerializedName("city")        var city: String?,
    @SerializedName("hostname")    var hostname: String?
) {
/*    fun getIp(): String? {
        return ip
    }

    fun setIp(ip: String?) {
        this.ip = ip
    }

    fun getIpDecimal(): Int? {
        return ipDecimal
    }

    fun setIpDecimal(ipDecimal: Int?) {
        this.ipDecimal = ipDecimal
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getCountryIso(): String? {
        return countryIso
    }

    fun setCountryIso(countryIso: String?) {
        this.countryIso = countryIso
    }

    fun getCity(): String? {
        return city
    }

    fun setCity(city: String?) {
        this.city = city
    }

    fun getHostname(): String? {
        return hostname
    }

    fun setHostname(hostname: String?) {
        this.hostname = hostname
    }*/
}