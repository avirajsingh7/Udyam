package com.example.udyam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class splash_screen_activity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if(user!=null){
                val dashboardIntent = Intent(this,MainActivity::class.java)
                startActivity(dashboardIntent)
                finish()
            }
            else{
                val LandingIntent = Intent(this,landing_page::class.java)
                startActivity(LandingIntent)
                finish()
            }
        },2000)
    }
}