package com.example.loginscreen.Api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface serviceInterface {
    @Headers("Content-Type:application/json")
    @GET("67c1f5f8ad1f5085ec60")
    fun getAllRides():Call<ApiResponse>
}