package com.kodluyoruz.loginpage

import android.os.Bundle
import com.kodluyoruz.loginpage.base.BaseActivity
import com.kodluyoruz.loginpage.utils.SharedPreferencesModule

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SharedPreferencesModule.initSharedPreferences(baseContext)
    }

    override fun onDestroy() {
        super.onDestroy()
        SharedPreferencesModule.unRegister()
    }
}