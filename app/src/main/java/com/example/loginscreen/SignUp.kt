package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {
    lateinit var SignUpBtn : Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_screens)

        SignUpBtn = findViewById(R.id.SignUpBtn)

        SignUpBtn.setOnClickListener {
            var intent = Intent(this , SignInScreen::class.java)
            startActivity(intent)
        }
    }
}