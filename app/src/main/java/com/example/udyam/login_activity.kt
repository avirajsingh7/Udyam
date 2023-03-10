package com.example.udyam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.udyam.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class login_activity : AppCompatActivity() {


    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAuth = FirebaseAuth.getInstance()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinBtn.setOnClickListener {
            val email = binding.siginEmail.text.toString()
            val password = binding.siginPass.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(Intent(this,MainActivity::class.java))
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

        binding.signupText.setOnClickListener {
            startActivity(Intent(this,signup_activity::class.java))
            finish()
        }

    }
}