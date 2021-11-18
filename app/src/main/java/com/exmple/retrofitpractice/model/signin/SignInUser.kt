package com.exmple.retrofitpractice.model.signin

import com.google.gson.annotations.SerializedName

data class SignInUser(
    @SerializedName("username") var userName:String,
    @SerializedName("password") var password:String,
)
