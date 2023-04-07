package com.example.tugaspendahuluan21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Detail2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail2)

        val txtNama = findViewById<TextView>(R.id.TXTnama)
        val txtEmail = findViewById<TextView>(R.id.TXTemail)
        val txtPhone = findViewById<TextView>(R.id.TXTphone)
        val txtAlamat= findViewById<TextView>(R.id.TXTalamat)

        val user: Data2Class = intent.getParcelableExtra("user")!!

        txtNama.text = user.name
        txtEmail.text = user.email
        txtPhone.text = user.phone
        txtAlamat.text = user.alamat
    }
}