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

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },2000)

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
            if(user!=null){
                val dashboardIntent = Intent(this,MainActivity::class.java)
                startActivity(dashboardIntent)
                finish()
            }
            else{
                val SignInIntent = Intent(this,login_activity::class.java)
                startActivity(SignInIntent)
                finish()
            }
        },2000)
    }
}