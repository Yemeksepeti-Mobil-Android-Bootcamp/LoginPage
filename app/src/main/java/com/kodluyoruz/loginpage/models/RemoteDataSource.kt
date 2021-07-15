package com.kodluyoruz.loginpage.models

import com.kodluyoruz.loginpage.models.entity.LoginRequest
import com.kodluyoruz.loginpage.models.entity.LoginResponse
import com.kodluyoruz.loginpage.utils.RetrofitHelper
import retrofit2.Callback

class RemoteDataSource {
    fun login(email: String, password: String, callback: Callback<LoginResponse>) {
        RetrofitHelper.getApiService().login(LoginRequest(email, password)).enqueue(callback)
    }
}