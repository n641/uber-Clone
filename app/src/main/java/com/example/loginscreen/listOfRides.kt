package com.example.loginscreen

import android.content.Intent
import android.os.Bundle
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.loginscreen.Adapter.RidesAdapter
import com.example.loginscreen.Api.ApiResponse
import com.example.loginscreen.Api.ServiceBuilder
import com.example.loginscreen.Api.serviceInterface
import com.example.loginscreen.Data.DummyData
import com.example.loginscreen.Data.Rides
import com.example.loginscreen.databinding.ActivityListOfRidesBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class listOfRides : AppCompatActivity() {
    lateinit var recyclerView :RecyclerView;
    lateinit var recyclerAdapter : RidesAdapter;
    lateinit var RidesArray : ArrayList<Rides>;


    lateinit var buyticket : Button;
    lateinit var binding :ActivityListOfRidesBinding
    lateinit var intent1 : Intent ;
    var data =ArrayList<com.example.loginscreen.Api.Rides>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var from = intent.getStringExtra("from")
        var to = intent.getStringExtra("to")
        intent1 = Intent(this , Details_page::class.java)

        println("from")
        println(from)

        StrictMode.setVmPolicy(
            VmPolicy.Builder(StrictMode.getVmPolicy())
                .detectLeakedClosableObjects()
                .build()
        )

        binding= ActivityListOfRidesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        getAllRides();
//        setRidesRecylerView(getAllRides());


    }


    fun getAllRides(): ArrayList<com.example.loginscreen.Api.Rides> {
        val retrofit= ServiceBuilder.buildService(serviceInterface::class.java)

        retrofit.getAllRides().enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {
                    println("flage")
                    println(response.body()?.Rides)

                    val responseBody = response.body()!!

                        data = responseBody.Rides
                        var filterData = ArrayList<com.example.loginscreen.Api.Rides>()


//                    for (x in data) {
//                        if(x.from == from && x.to == to)
//                            filterData.add(x)
//                    }
                        val adapter=RidesAdapter(data)
                        binding.recyclerView.adapter =adapter

                        buyticket = findViewById(R.id.buyTicket);
                        buyticket.setOnClickListener {
                            startActivity(intent1)
                        }

                }catch (ex: java.lang.Exception){
                        ex.printStackTrace()
                }
            }
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
//                Log.e("failed" ,"Api failed" ,t.cause)
                println("error")
                println(t.message)

            }
        })
    return data
    }

//        private fun setRidesRecylerView(allRides:ArrayList<com.example.loginscreen.Api.Rides>){
//        recyclerView = findViewById(R.id.recyclerView)
//        val layoutManager : RecyclerView.LayoutManager= LinearLayoutManager(this)
//        recyclerView.layoutManager = layoutManager
//        recyclerAdapter= RidesAdapter(allRides)
//        recyclerView!!.adapter = recyclerAdapter
//
//    }
//    private fun setRidesData() : ArrayList<Rides>{
//        val ridesList : ArrayList<Rides> = ArrayList()
//        dummy.addRides(ridesList)
//        return ridesList
//    }
}

