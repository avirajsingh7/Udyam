package com.example.udyam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.udyam.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth

class signup_activity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()


        binding.signUpButton.setOnClickListener {
            val email = binding.signUpEmail.text.toString()
            val password = binding.signUpPassword.text.toString()
            val name = binding.signUpName.toString()

            if(email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val login_intent = Intent(this,login_activity::class.java)
                        startActivity(login_intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this,"Enter Details Correctly", Toast.LENGTH_LONG).show()
            }
        }

        binding.signinText.setOnClickListener {

            startActivity(Intent(this,login_activity::class.java))
            finish()
        }

    }
}