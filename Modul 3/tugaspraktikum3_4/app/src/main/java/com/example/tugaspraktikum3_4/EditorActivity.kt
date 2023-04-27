package com.example.tugaspraktikum3_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tugaspraktikum3_4.data.AppDatabase
import com.example.tugaspraktikum3_4.data.entity.User

class EditorActivity : AppCompatActivity() {
    private lateinit var nim: EditText
    private lateinit var fullName: EditText
    private lateinit var email: EditText
    private lateinit var phone: EditText
    private lateinit var alamat: EditText
    private lateinit var btnSave: Button
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editor)

        nim = findViewById(R.id.nim)
        fullName = findViewById(R.id.full_name)
        email = findViewById(R.id.email)
        phone = findViewById(R.id.phone)
        alamat = findViewById(R.id.alamat)
        btnSave = findViewById(R.id.btn_save)

        database = AppDatabase.getInstance(applicationContext)

        val intent = intent.extras
        if (intent!=null){
            supportActionBar?.apply {
                title = "Update Data Mahasiswa"
            }

            val id = intent.getString("id")
            var user = database.userDao().get(id)

            btnSave.setText("Update")

            nim.setText(user.nim)
            fullName.setText(user.fullName)
            email.setText(user.email)
            phone.setText(user.phone)
            alamat.setText(user.alamat)

            nim.isFocusable = false
            nim.isFocusableInTouchMode = false
        }else{
            supportActionBar?.apply {
                title = "Tambah Data Mahasiswa"
            }
        }

        btnSave.setOnClickListener {
            if (nim.text.isNotEmpty() && fullName.text.isNotEmpty() &&
                email.text.isNotEmpty() && phone.text.isNotEmpty() &&
                alamat.text.isNotEmpty()) {
                if (intent!=null){
                    //edit data
                    database.userDao().update(
                        intent.getString("id")?.let { it1 ->
                            User(
                                it1,
                                fullName.text.toString(),
                                email.text.toString(),
                                phone.text.toString(),
                                alamat.text.toString()
                            )
                        }!!
                    )
                    Toast.makeText(
                        applicationContext,
                        "Data berhasil diperbaharui!!!",
                        Toast.LENGTH_SHORT
                    ).show()
                }else{
                    // cek nim
                    val newNIM = nim.text.toString()
                    val isCheckSuccessful = checkNIM(newNIM)
                    if (isCheckSuccessful) {
                        // Check NIM berhasil alias NIM sudah ada
                        Toast.makeText(
                            applicationContext,
                            "NIM sudah ada, data gagal ditambahkan!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // NIM masih tersedia alias belum terdaftar
                        // tambah data
                        database.userDao().insertAll(
                            User(
                                nim.text.toString(),
                                fullName.text.toString(),
                                email.text.toString(),
                                phone.text.toString(),
                                alamat.text.toString()
                            )
                        )
                        Toast.makeText(
                            applicationContext,
                            "Data berhasil ditambahkan!!!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Silahkan isi semua data dengan valid",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    fun checkNIM(newNIM: String): Boolean {
        val cekNIM = database.userDao().get(newNIM)
        return cekNIM != null
    }

}