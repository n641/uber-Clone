package com.example.loginscreen.Api

import com.google.gson.annotations.SerializedName

class ApiResponse (
    @SerializedName("Rides" ) var Rides : ArrayList<Rides> = arrayListOf()
)

data class Rides (

    @SerializedName("id"       ) var id       : String? = null,
    @SerializedName("to"       ) var to       : String? = null,
    @SerializedName("time"     ) var time     : String? = null,
    @SerializedName("from"     ) var from     : String? = null,
    @SerializedName("price"    ) var price    : String? = null,
    @SerializedName("dateTo"   ) var dateTo   : String? = null,
    @SerializedName("dateFrom" ) var dateFrom : String? = null

)