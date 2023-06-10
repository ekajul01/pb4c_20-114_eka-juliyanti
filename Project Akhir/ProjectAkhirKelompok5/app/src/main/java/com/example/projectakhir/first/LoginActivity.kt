package com.example.projectakhir.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.projectakhir.MainActivity
import com.example.projectakhir.R
import com.example.projectakhir.data.AppDatabase
import com.example.projectakhir.helper.SharedPreference

class LoginActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var register: TextView
    private lateinit var btnlogin: Button
    private lateinit var database: AppDatabase
    private lateinit var sPH: SharedPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        register = findViewById(R.id.register)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btnlogin = findViewById(R.id.btn_login)
        sPH = SharedPreference(this)

        database = AppDatabase.getInstance(applicationContext)

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        btnlogin.setOnClickListener {
            val inputemail= email.text.toString()
            val inputpassword = password.text.toString()

            if (inputemail.isNotEmpty() && inputpassword.isNotEmpty()) {
                val loginakun = database.userDao().login(inputemail, inputpassword)
                if (loginakun != null) {
                    //Login berhasil, lanjutkan ke halaman pengguna
                    // val fragment = ProfilFragment()
                    val x = loginakun.email

                    sPH.setStatusLogin(true)
                    sPH.setDataLogin(x)

                    //val bundle = Bundle()
                    //bundle.putString("email", x)
                    //fragment.arguments = bundle
                    //supportFragmentManager.beginTransaction().add(R.id.frameLayout, fragment).commit()

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("email", inputemail)
                    startActivity(intent)
                    Toast.makeText(this, "Anda berhasil login", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(
                    applicationContext,
                    "Silahkan isi semua data dengan valid!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
