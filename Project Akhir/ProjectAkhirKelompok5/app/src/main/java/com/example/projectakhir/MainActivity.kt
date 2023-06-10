package com.example.projectakhir

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.projectakhir.databinding.ActivityMainBinding
import com.example.projectakhir.first.LoginActivity
import com.example.projectakhir.helper.SharedPreference
import com.example.projectakhir.home.HomeFragment
import com.example.projectakhir.profile.ProfilFragment
import com.example.projectakhir.tambahdata.DataFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sPH: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sPH = SharedPreference(this)
        replaceFragment(HomeFragment())

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.rgb(58,175,175)))

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> {
                    if(sPH.getStatusLogin()){
                        replaceFragment(HomeFragment())
                    }else{
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
                R.id.data -> {
                    if(sPH.getStatusLogin()){
                        replaceFragment(DataFragment())
                    }else{
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
                R.id.profil -> {
                    if(sPH.getStatusLogin()){
                        replaceFragment(ProfilFragment())
                    }else{
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
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