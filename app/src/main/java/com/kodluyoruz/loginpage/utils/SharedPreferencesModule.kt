package com.kodluyoruz.loginpage.utils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SharedPreferencesModule {
    const val TOKEN = "com.kodluyoruz.loginpage.TOKEN"

    private var sharedPreferences: SharedPreferences? = null

    fun initSharedPreferences(context: Context) {
        sharedPreferences =
            context.getSharedPreferences("sharedPreferencesUtil", Context.MODE_PRIVATE)
        sharedPreferences?.registerOnSharedPreferenceChangeListener { sharedPreferences, key ->
            Log.v("SharedPref", "$key changed ${sharedPreferences.all}")
        }
    }

    fun unRegister() {
        sharedPreferences?.unregisterOnSharedPreferenceChangeListener { _, _ ->

        }
    }

    fun saveString(key: String, value: String) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun getString(key: String, defaultVal: String = ""): String {
        return sharedPreferences?.getString(key, defaultVal) ?: ""
    }

}