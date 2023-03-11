package com.example.udyam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udyam.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        binding.signOut.setOnClickListener {

            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut();
            startActivity(Intent(this,login_activity::class.java))
            finish()
        }

    }
}