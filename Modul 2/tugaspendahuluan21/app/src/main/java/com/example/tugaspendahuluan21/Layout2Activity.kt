package com.example.tugaspendahuluan21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Layout2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout2)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        val btnCancel= findViewById<Button>(R.id.btnCancel)
        val txtNama = findViewById<EditText>(R.id.txtNama)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtPhone = findViewById<EditText>(R.id.txtPhone)
        val txtAlamat= findViewById<EditText>(R.id.txtAlamat)
        btnCancel.setOnClickListener {
            txtNama.setText("")
            txtEmail.setText("")
            txtPhone.setText("")
            txtAlamat.setText("")
        }
        btnSimpan.setOnClickListener{
            if(txtNama.text.isNotEmpty() &&
                txtEmail.text.isNotEmpty() &&
                txtPhone.text.isNotEmpty() &&
                txtAlamat.text.isNotEmpty()) {
                val name1 = txtNama.text.toString()
                val email1 = txtEmail.text.toString()
                val phone1 = txtPhone.text.toString()
                val alamat1 = txtAlamat.text.toString()

                val user = Data2Class(name1, email1, phone1, alamat1)

                val intent = Intent(this, Detail2Activity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }
    }
}