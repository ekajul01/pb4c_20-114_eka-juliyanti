package com.example.tugaspraktikum6

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.tugaspraktikum6.Fragment.CallFragment
import com.example.tugaspraktikum6.Fragment.ChatFragment
import com.example.tugaspraktikum6.Fragment.StatusFragment
import com.example.tugaspraktikum6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.rgb(45,61,71)))
        replaceFragment(ChatFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.chat -> replaceFragment(ChatFragment())
                R.id.status -> replaceFragment(StatusFragment())
                R.id.call -> replaceFragment(CallFragment())

                else ->{}
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

    }
}
