package com.example.loginscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginscreen.databinding.SignupScreensBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    lateinit var SignUpBtn : Button;
    lateinit var binding: SignupScreensBinding
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignupScreensBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.SignUpBtn.setOnClickListener {
            val userName = binding.userName.text.toString()
            val email = binding.Email.text.toString()
            val pass = binding.Password.text.toString()
            val comformPass = binding.confirmPassword.text.toString()

            if(email.isNotEmpty() && pass.isNotEmpty() && comformPass.isNotEmpty() && userName.isNotEmpty()){

                if(pass == comformPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                        if(it.isSuccessful){
                            var intent = Intent(this , SignInScreen::class.java)
                            startActivity(intent)
                        }else{
                            println("it.exception.toString()")
                            println(it.exception.toString())

                            Toast.makeText(this , it.exception.toString() , Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this , "password does not match" , Toast.LENGTH_SHORT).show()
                }
           }else if(email.isEmpty()){
                Toast.makeText(this , "enter email" , Toast.LENGTH_SHORT).show()

            }else if(userName.isEmpty()){
                Toast.makeText(this , "enter username" , Toast.LENGTH_SHORT).show()

            }
        }

        binding.textSignUp.setOnClickListener{
            var intent = Intent(this , SignInScreen::class.java)
            startActivity(intent)
        }

    }
}