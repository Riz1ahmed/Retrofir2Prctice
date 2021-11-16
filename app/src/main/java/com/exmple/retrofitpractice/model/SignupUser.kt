package com.exmple.retrofitpractice.model

import com.google.gson.annotations.SerializedName

data class SignupUser(
    @SerializedName("full_name") var fullName:String,
    @SerializedName("phone_number") var phoneNo:String,
    @SerializedName("password") var password:String,
)
