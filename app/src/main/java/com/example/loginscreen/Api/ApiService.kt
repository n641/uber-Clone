package com.example.loginscreen.Api
import retrofit2.Retrofit
//import retrofit2.converter.scalars.ScalarsConverterFactory

import retrofit2.http.GET

    private val BASE_URL =
        "https://api.npoint.io/63344463478e86537cf9";

    private val retrofit = Retrofit.Builder()
//        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()



    interface ApiService {
        @GET("name")
        suspend fun getPhotos(): String
    }

    object Api {
        val retrofitService: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
