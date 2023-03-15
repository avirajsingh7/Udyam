package com.example.udyam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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

        binding.bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home ->replaceFragment(Home())
                R.id.map ->replaceFragment(MapsFragment())
                R.id.schedule ->replaceFragment(Schedule())
                R.id.leaderboard ->replaceFragment(LeaderBoard())
                R.id.profile ->replaceFragment(Profile())

                else ->{

                }

            }
            true
        }


        binding.signOut.setOnClickListener {

            firebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.signOut();
            startActivity(Intent(this,login_activity::class.java))
            finish()
        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }
}