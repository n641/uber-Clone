package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Home : AppCompatActivity() {
    lateinit var searchBtn : Button;
    lateinit var TFfrom : EditText
    lateinit var TFto : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        TFfrom = findViewById(R.id.TFfrom)
        TFto = findViewById(R.id.TFto)
        searchBtn =findViewById(R.id.searchBtn)

        searchBtn.setOnClickListener {
            var intent1 = Intent(this , listOfRides::class.java)
            intent1.putExtra("from" , TFfrom.text)
            intent1.putExtra("to" , TFto.text)
            startActivity(intent1)
        }

    }

}