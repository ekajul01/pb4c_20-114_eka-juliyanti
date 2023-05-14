package com.example.tugaspraktikum5

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.viewpager.widget.ViewPager
import com.example.tugaspraktikum5.Adapter.FragmentAdapter
import com.example.tugaspraktikum5.Fragment.CallFragment
import com.example.tugaspraktikum5.Fragment.ChatFragment
import com.example.tugaspraktikum5.Fragment.StatusFragment
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.rgb(45,61,71)))

        var viewPager: ViewPager = findViewById(R.id.viewPager)
        var tablayout: TabLayout = findViewById(R.id.tablayout)

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(ChatFragment(), "Chats")
        fragmentAdapter.addFragment(StatusFragment(), "Status")
        fragmentAdapter.addFragment(CallFragment(), "Calls")

        viewPager.adapter = fragmentAdapter
        tablayout.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu,menu)
        return true
    }
}
