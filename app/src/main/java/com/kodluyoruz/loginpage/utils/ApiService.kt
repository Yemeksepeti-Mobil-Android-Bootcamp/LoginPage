package com.kodluyoruz.loginpage.utils

import com.kodluyoruz.loginpage.models.entity.LoginRequest
import com.kodluyoruz.loginpage.models.entity.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}

