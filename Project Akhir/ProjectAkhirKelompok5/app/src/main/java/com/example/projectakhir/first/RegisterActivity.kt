package com.example.projectakhir.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.projectakhir.R
import com.example.projectakhir.data.AppDatabase
import com.example.projectakhir.data.entity.User

class RegisterActivity : AppCompatActivity() {

    private lateinit var nama: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var loginakun: TextView
    private lateinit var btndaftar: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        loginakun = findViewById(R.id.masuk)
        nama = findViewById(R.id.nama)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btndaftar = findViewById(R.id.btn_daftar)

        database = AppDatabase.getInstance(applicationContext)

        loginakun.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        btndaftar.setOnClickListener {
            if (nama.text.isNotEmpty() && email.text.isNotEmpty() && password.text.isNotEmpty()) {
                val newEmail = email.text.toString()
                val isCheckSuccessful = checkEmail(newEmail)
                if (isCheckSuccessful) {
                    // Check Email berhasil alias Email sudah ada
                    Toast.makeText(
                        applicationContext,
                        "Email sudah ada, silahkan gunakan email lain!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Email masih tersedia alias belum terdaftar
                    database.userDao().insertAll(
                        User(
                            email.text.toString(),
                            nama.text.toString(),
                            password.text.toString()
                        )
                    )
                    Toast.makeText(
                        applicationContext,
                        "Data berhasil ditambahkan!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                finish()
            }else{
                Toast.makeText(
                    applicationContext,
                    "Silahkan isi semua data dengan valid!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun checkEmail(newEmail: String): Boolean {
        val cekEmail = database.userDao().getUser(newEmail)
        return cekEmail != null
    }
}