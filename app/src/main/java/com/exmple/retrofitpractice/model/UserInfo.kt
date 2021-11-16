package com.exmple.retrofitpractice.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("id") val id: Long,
    @SerializedName("username") val userName: String,
    @SerializedName("email") val email: String,
    @SerializedName("profile") val profile: Profile,
    @SerializedName("date_joined") val dateJoined: String
)

