package com.kodluyoruz.loginpage.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kodluyoruz.loginpage.utils.SharedPreferencesModule

class SplashViewModel : ViewModel() {
    private var loginStateLiveData = MutableLiveData<String>()

    fun getLoginObserver(): LiveData<String> = loginStateLiveData

    fun checkUserLoginState() {
        val token = SharedPreferencesModule.getString(SharedPreferencesModule.TOKEN, "")
        if (token.isEmpty()) {
            //navigate to login
            loginStateLiveData.value = "login"
//            loginStateLiveData.postValue("login")

        } else {
            //navigate to main
            loginStateLiveData.value = "main"
//            loginStateLiveData.postValue("main")
        }
    }
}