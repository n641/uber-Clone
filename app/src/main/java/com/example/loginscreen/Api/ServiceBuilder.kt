package com.example.loginscreen.Api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

object ServiceBuilder {
    private val BASE_URL =
        "https://api.npoint.io";

    private val client =OkHttpClient.Builder().build()
    val key ="67c1f5f8ad1f5085ec60";
     private val retrofit = Retrofit.Builder()
         .baseUrl(BASE_URL)
         .addConverterFactory(GsonConverterFactory.create())
         .client(client)
         .build()

    fun<T> buildService(service: Class<T>):T{
        return retrofit.create(service)
    }
}