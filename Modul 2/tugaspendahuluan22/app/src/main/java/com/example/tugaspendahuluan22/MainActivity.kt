package com.example.tugaspendahuluan22
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNama = findViewById<EditText>(R.id.textNama)
        val imgButtonAdd = findViewById<Button>(R.id.imgButtonAdd)
        val imgButtonCancel = findViewById<Button>(R.id.imgButtonCancel)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val rbWanita = findViewById<RadioButton>(R.id.rbWanita)
        val rbPria = findViewById<RadioButton>(R.id.rbPria)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbReading = findViewById<CheckBox>(R.id.cbReading)
        val cbTravelling= findViewById<CheckBox>(R.id.cbTravelling)

        imgButtonAdd.setOnClickListener{
            val gender: String

            if (rbWanita.isChecked) {
                gender = rbWanita.text.toString()
            } else if (rbPria.isChecked) {
                gender = rbPria.text.toString()
            } else {
                gender = " "
            }
            val tampil = "Nama: "+editTextNama.getText()+
                    ", Gender: " +gender+
                    " telah berhasil disimpan"
            Toast.makeText(this@MainActivity, tampil, Toast.LENGTH_SHORT).show()
        }

        imgButtonCancel.setOnClickListener{
            editTextNama.setText("")
            radioGroup.clearCheck()
            cbCoding.isChecked = false
            cbReading.isChecked = false
            cbTravelling.isChecked = false
        }
    }
    fun printHobi(view: View) {
        val checkBox = view as CheckBox
        val hobi = checkBox.text.toString()
        val message = if (checkBox.isChecked) {
            "Anda memilih hobi $hobi"
        } else {
            "Anda membatalkan pilihan hobi $hobi"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
