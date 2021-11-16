package com.exmple.retrofitpractice.model

import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("id") val id: Long,
    @SerializedName("created_date") val createdDate: String,
    @SerializedName("modified_date") val modifiedDate: String,
    @SerializedName("full_name") val fullName: String,
    @SerializedName("phone_number") val phoneNumber: String,
    @SerializedName("dob") val dateOfBirth: String?,
    @SerializedName("gender") val gender: String,
    @SerializedName("user") val user: Long,
)
