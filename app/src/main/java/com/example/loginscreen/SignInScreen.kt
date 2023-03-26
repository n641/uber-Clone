package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.loginscreen.databinding.LoginScreenBinding
import com.example.loginscreen.databinding.SignupScreensBinding
import com.google.firebase.auth.FirebaseAuth


class SignInScreen : AppCompatActivity() {

    lateinit var LoginBtn :Button;
    lateinit var SignUpText : TextView;
    lateinit var EmailTF : EditText;
    lateinit var PasswordTF : EditText;

    lateinit var binding: LoginScreenBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginBtn.setOnClickListener {
            val email = binding.EmailLoginTF.text.toString()
            val pass = binding.PasswordLoginTF.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() ){

                    firebaseAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            var intent = Intent(this , Home::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this , it.exception.toString() , Toast.LENGTH_SHORT).show()
                            println(it.exception.toString())
                        }
                    }

            }else if(email.isEmpty()){
                Toast.makeText(this , "enter email" , Toast.LENGTH_SHORT).show()

            }else if(pass.isEmpty()){
                Toast.makeText(this , "enter username" , Toast.LENGTH_SHORT).show()

            }

        }

        binding.textSignUp.setOnClickListener {

            var intent = Intent(this , SignUp::class.java)
            startActivity(intent)
        }

        binding.google.setOnClickListener {

        }


    }
}