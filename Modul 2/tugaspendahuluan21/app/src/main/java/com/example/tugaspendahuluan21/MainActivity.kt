package com.example.tugaspendahuluan21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnIntent1: Button
    private lateinit var btnIntent2: Button
    private lateinit var btnIntent3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnIntent1 = findViewById(R.id.button1)
        btnIntent1.setOnClickListener(this)
        btnIntent2 = findViewById(R.id.button2)
        btnIntent2.setOnClickListener(this)
        btnIntent3 = findViewById(R.id.button3)
        btnIntent3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button1 -> {
                val IntentBiasa1 = Intent(this, Layout1Activity::class.java)
                startActivity(IntentBiasa1)
            }
            R.id.button2 -> {
                val IntentBiasa2 = Intent(this, Layout2Activity::class.java)
                startActivity(IntentBiasa2)
            }
            R.id.button3 -> {
                val IntentBiasa3 = Intent(this, Layout3Activity::class.java)
                startActivity(IntentBiasa3)
            }
        }
    }
}
