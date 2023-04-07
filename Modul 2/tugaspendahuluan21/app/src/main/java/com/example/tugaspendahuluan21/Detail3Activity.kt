package com.example.tugaspendahuluan21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Detail3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail3)

        val txtNama = findViewById<TextView>(R.id.TXTnama)
        val txtEmail = findViewById<TextView>(R.id.TXTemail)
        val txtPass = findViewById<TextView>(R.id.TXTphone)
        val txtKonfPass= findViewById<TextView>(R.id.TXTalamat)

        val user: Data3Class = intent.getParcelableExtra("user")!!
        val nama = user.namedepan + " "+ user.namebelakang

        txtNama.text = nama
        txtEmail.text = user.email
        txtPass.text = user.password
        txtKonfPass.text = user.konfpassword
    }
}