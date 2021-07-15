package com.kodluyoruz.loginpage.models.entity


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data")
    val data: User,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("token")
    val token: String
)