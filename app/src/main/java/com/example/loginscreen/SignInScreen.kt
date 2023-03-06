package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class SignInScreen : AppCompatActivity() {

    lateinit var LoginBtn :Button;
    lateinit var SignUpText : TextView;
    lateinit var EmailTF : EditText;
    lateinit var PasswordTF : EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_screen)

        LoginBtn =findViewById(R.id.loginBtn)
        EmailTF = findViewById(R.id.userNameLoginTF)
        PasswordTF = findViewById(R.id.PasswordLoginTF)
        SignUpText = findViewById(R.id.textSignUp)

        LoginBtn.setOnClickListener {
//            if(EmailTF.text.toString()=="" ){
//                EmailTF.error="fill email";
//            }
//            if(PasswordTF.text.toString()==""){
//                PasswordTF.error="fill email";
//            }
//            var intent :Intent = Intent(this , )
        }

        SignUpText.setOnClickListener {

            var intent = Intent(this , SignUp::class.java)
            startActivity(intent)
        }

        LoginBtn.setOnClickListener {

            var intent = Intent(this , Home::class.java)
            startActivity(intent)
        }


    }
}