package com.kodluyoruz.loginpage.utils

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val token = SharedPreferencesModule.getString(SharedPreferencesModule.TOKEN, "")
            val request = it.request().newBuilder()
            if (token.isNotEmpty()) {
                Log.v("RetrofitHelper", "Headers auth added.")
                request
                    .addHeader("Authorization", "$token")
            }
            it.proceed(request.build())
        }
        .addInterceptor(HttpLoggingInterceptor())
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dist-learn.herokuapp.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private val service: ApiService = retrofit.create(ApiService::class.java)

    fun getApiService(): ApiService = service

}