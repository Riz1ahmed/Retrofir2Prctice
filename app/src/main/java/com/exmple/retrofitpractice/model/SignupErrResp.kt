package com.exmple.retrofitpractice.model

import com.google.gson.annotations.SerializedName

data class SignupErrResp(
    //Error
    @SerializedName("non_field_errors") val nonFieldErrors: List<String>?,
    //Some blank input
    @SerializedName("full_name") var fullNameError: List<String>?,
    @SerializedName("phone_number") var phoneNumberError: List<String>?,
    @SerializedName("password") var passwordError: List<String>?
)

/**
HTTP 201 Created
Allow: POST, OPTIONS
Content-Type: application/json
Vary: Accept

{
"token": "2f6010565a702664e61581c0369d7c718ade4ede",
"user_info": {
"id": 3,
"username": "01775384108",
"email": "",
"profile": {
"id": 2,
"created_date": "2021-11-16T09:25:48.155038Z",
"modified_date": "2021-11-16T09:25:48.155112Z",
"full_name": "Rizwan Ahmed",
"phone_number": "01775384108",
"dob": null,
"gender": "",
"user": 3
},
"date_joined": "2021-11-16T09:25:47.910681Z"
}
}



//If error
{
"non_field_errors": [
"Phone Number already registered."
]
}
 *
 */
