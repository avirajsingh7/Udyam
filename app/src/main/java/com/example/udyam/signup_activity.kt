package com.example.udyam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.udyam.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signup_activity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database:DatabaseReference
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

                        val currUser = firebaseAuth.currentUser

                        database = FirebaseDatabase.getInstance().getReference("Users")
                        val user = user(name,email)
                        database.child(currUser!!.uid).child("Profile").setValue(user).addOnSuccessListener {
                            Toast.makeText(this,"Profile Created Successfully",Toast.LENGTH_SHORT).show()
                        }.addOnFailureListener {
                            Toast.makeText(this,"Profile not Created",Toast.LENGTH_SHORT).show()
                        }

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