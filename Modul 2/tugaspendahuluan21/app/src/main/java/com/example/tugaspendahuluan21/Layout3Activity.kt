package com.example.tugaspendahuluan21
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class Layout3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout3)
        val btnDaftar = findViewById<Button>(R.id.btnDaftar)
        val txtNamaDep = findViewById<EditText>(R.id.txtNamaDepan)
        val txtNamaBel = findViewById<EditText>(R.id.txtNamaBelakang)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val txtPassword = findViewById<EditText>(R.id.txtPassword)
        val txtKonfPass = findViewById<EditText>(R.id.txtKonfPassword)
        btnDaftar.setOnClickListener{
            val name1 = txtNamaDep.text.toString()
            val name2 = txtNamaBel.text.toString()
            val email1 = txtEmail.text.toString()
            val password1 = txtPassword.text.toString()
            val konfpass1 = txtKonfPass.text.toString()
            if(password1 == konfpass1){
                if(txtNamaDep.text.isNotEmpty() && txtNamaBel.text.isNotEmpty() && txtEmail.text.isNotEmpty() &&
                    txtPassword.text.isNotEmpty() && txtKonfPass.text.isNotEmpty()) {
                    val user = Data3Class(name1, name2, email1, password1,konfpass1)
                    val intent = Intent(this, Detail3Activity::class.java)
                    intent.putExtra("user", user)
                    startActivity(intent)
                }
            }else{
                Toast.makeText(applicationContext, "Password Tidak Sama", Toast.LENGTH_SHORT).show()
            }
        }
    }
}