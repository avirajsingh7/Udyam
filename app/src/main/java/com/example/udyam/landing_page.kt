package com.example.udyam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.udyam.databinding.ActivityLandingPageBinding

class landing_page : AppCompatActivity() {

    private  lateinit var binding: ActivityLandingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this,login_activity::class.java))
            finish()
        }
        binding.textView3.setOnClickListener {
            startActivity(Intent(this,signup_activity::class.java))
            finish()
        }



    }
}