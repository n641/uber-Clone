package com.example.loginscreen.Data

import com.example.loginscreen.Api.ApiResponse
import com.example.loginscreen.Api.ServiceBuilder
import com.example.loginscreen.Api.serviceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DummyData {
    fun addRides(ridesList : ArrayList<Rides>){
        ridesList.add(Rides("1","Giza","Naser City" , "9:00 AM" ,"19-Dec-2019" ,"19-Dec-2019" ,"50$" ))
        ridesList.add(Rides("1","Giza","Naser City" , "9:00 AM" ,"19-Dec-2019" ,"19-Dec-2019" ,"50$" ))
        ridesList.add(Rides("1","Giza","Naser City" , "9:00 AM" ,"19-Dec-2019" ,"19-Dec-2019" ,"50$" ))
        ridesList.add(Rides("1","Giza","Naser City" , "9:00 AM" ,"19-Dec-2019" ,"19-Dec-2019" ,"50$" ))
        ridesList.add(Rides("1","Giza","Naser City" , "9:00 AM" ,"19-Dec-2019" ,"19-Dec-2019" ,"50$" ))
        ridesList.add(Rides("1","Giza","Naser City" , "9:00 AM" ,"19-Dec-2019" ,"19-Dec-2019" ,"50$" ))
    }

    fun getAllRides(){
        val retrofit= ServiceBuilder.buildService(serviceInterface::class.java)

        retrofit.getAllRides().enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {

                }catch (ex: java.lang.Exception){

                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}