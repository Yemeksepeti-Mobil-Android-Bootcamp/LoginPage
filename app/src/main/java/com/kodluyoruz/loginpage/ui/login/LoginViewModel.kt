package com.kodluyoruz.loginpage.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.loginpage.models.ApiRepository

class LoginViewModel : ViewModel() {
    val apiRepository: ApiRepository = ApiRepository()
    private var loginLiveData: MutableLiveData<String> = MutableLiveData()

    fun getTokenLiveData(): LiveData<String> = loginLiveData

    fun login() {
        try {
            loginLiveData = apiRepository.login("tunahan@aydinoglu.com", "123qweqwe")
        } catch (e: Exception) {
            Log.v("LoginViewModel", e.toString())
        }
    }
}