package com.kodluyoruz.loginpage.models

import androidx.lifecycle.MutableLiveData
import com.kodluyoruz.loginpage.models.entity.LoginResponse
import com.kodluyoruz.loginpage.utils.SharedPreferencesModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepository {

    val remoteDataSource = RemoteDataSource()

    fun login(email: String, password: String): MutableLiveData<String> {
        val loginLiveData = MutableLiveData<String>()
        remoteDataSource.login(email, password, callback = object :
            Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        SharedPreferencesModule.saveString(SharedPreferencesModule.TOKEN, it.token)
                        loginLiveData.postValue(it.token)
                    }
                } else {
                    throw Exception("Wrong Credentials")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                throw Exception("Service Error")
            }
        })
        return loginLiveData
    }
}