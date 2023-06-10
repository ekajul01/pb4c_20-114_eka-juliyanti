package com.example.projectakhir.tambahdata

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.projectakhir.R
import com.example.projectakhir.data.AppDatabase
import com.example.projectakhir.data.entity.Kriteria
import com.example.projectakhir.helper.SharedPreference

class DataKriteriaFragment : Fragment() {

    private lateinit var etNamaKriteria: EditText
    private lateinit var etNoted: TextView
    private lateinit var dropDownKepentingan: AutoCompleteTextView
    private lateinit var dropDownAtribut: AutoCompleteTextView
    private lateinit var btnSimpanKriteria: Button
    private lateinit var database: AppDatabase
    private lateinit var sPH: SharedPreference

    override fun onAttach(context: Context) {
        super.onAttach(context)
        database = AppDatabase.getInstance(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_data_kriteria, container, false)

        val jmlKriteria = database.kriteriaDao().getCountKriteria()

        etNamaKriteria = view.findViewById(R.id.namakriteria)
        etNoted = view.findViewById(R.id.noted)
        btnSimpanKriteria = view.findViewById(R.id.btn_simpanKriteria)
        dropDownAtribut = view.findViewById(R.id.dropDownAtribut)
        dropDownKepentingan = view.findViewById(R.id.dropDownKepentingan)

        dropDownKepentingan.isFocusable = false
        dropDownAtribut.isFocusable = false

        if (jmlKriteria == 3){
            btnSimpanKriteria.isEnabled = false
            etNoted.setText("Noted : Kriteria Maksimum 3")
        }

        val itemsKepentingan = listOf("Sangat Tinggi", "Tinggi", "Cukup", "Rendah", "Sangat Rendah")
        val itemsAtribut = listOf("cost", "benefit")

        val adapterKepentingan = ArrayAdapter(requireContext(), R.layout.listkepentingan, itemsKepentingan)
        dropDownKepentingan.setAdapter(adapterKepentingan)

        val adapterAtribut = ArrayAdapter(requireContext(), R.layout.listatribut, itemsAtribut)
        dropDownAtribut.setAdapter(adapterAtribut)

        btnSimpanKriteria.setOnClickListener {
            if(etNamaKriteria.text.toString().isNotEmpty() && dropDownKepentingan.text.toString().isNotEmpty() &&
                dropDownAtribut.text.toString().isNotEmpty()){
                var tampilNamaKriteria = etNamaKriteria.text.toString()
                var selectedValueKepentingan= dropDownKepentingan.text.toString()
                var selectedValueAtribut = dropDownAtribut.text.toString()

                var tampilKepentingan: Int
                if (selectedValueKepentingan == "Sangat Tinggi"){
                    tampilKepentingan = 5
                }else if (selectedValueKepentingan == "Tinggi"){
                    tampilKepentingan = 4
                }else if (selectedValueKepentingan == "Cukup"){
                    tampilKepentingan = 3
                }else if (selectedValueKepentingan == "Rendah"){
                    tampilKepentingan = 2
                }else{
                    tampilKepentingan = 1
                }

                var tampilAtribut: String
                if (selectedValueAtribut == "cost"){
                    tampilAtribut = "cost"
                }else{
                    tampilAtribut = "benefit"
                }

                val output = "Hasil: $tampilNamaKriteria $tampilKepentingan $tampilAtribut"

                database.kriteriaDao().insertAllKriteria(
                    Kriteria(
                        null,
                        tampilNamaKriteria,
                        tampilKepentingan,
                        tampilAtribut
                    )
                )
                etNamaKriteria.setText("")
                dropDownAtribut.setText("")
                dropDownKepentingan.setText("")
                Toast.makeText(
                    requireContext(),
                    "Data berhasil ditambahkan!!!",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    requireContext(),
                    "isi data dulu",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }

}