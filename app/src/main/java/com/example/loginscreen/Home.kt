package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    lateinit var searchBtn : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        searchBtn =findViewById(R.id.searchBtn)

        searchBtn.setOnClickListener {

            var intent = Intent(this , listOfRides::class.java)
            startActivity(intent)
        }

    }


}