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
import com.example.projectakhir.data.entity.Wisataku
import com.example.projectakhir.helper.SharedPreference

class DataWisataFragment : Fragment() {
    private lateinit var etNamaWisata: EditText
    private lateinit var dropDownJarak: AutoCompleteTextView
    private lateinit var dropDownHarga: AutoCompleteTextView
    private lateinit var dropDownKendaraan: AutoCompleteTextView
    private lateinit var btnSimpan: Button
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
        val view = inflater.inflate(R.layout.fragment_data_wisata, container, false)

        val itemsJarak = listOf("0-10 KM", "11-50 KM", ">50 KM")
        val itemsHarga = listOf("<20.000", "20.000-100.000", ">100.0000")
        val itemsKendaraan = listOf("Roda4", "Roda2", "Perahu")
        etNamaWisata = view.findViewById(R.id.namawisata)
        btnSimpan = view.findViewById(R.id.btn_simpanWisata)

        val adapterJarak = ArrayAdapter(requireContext(), R.layout.listjarak, itemsJarak)
        dropDownJarak = view.findViewById(R.id.dropDownJarak)
        dropDownJarak.setAdapter(adapterJarak)

        val adapterHarga = ArrayAdapter(requireContext(), R.layout.listharga, itemsHarga)
        dropDownHarga = view.findViewById(R.id.dropDownHarga)
        dropDownHarga.setAdapter(adapterHarga)

        val adapterKendaraan = ArrayAdapter(requireContext(), R.layout.listkendaraan, itemsKendaraan)
        dropDownKendaraan = view.findViewById(R.id.dropDownKendaraan)
        dropDownKendaraan.setAdapter(adapterKendaraan)

        dropDownJarak.isFocusable = false
        dropDownHarga.isFocusable = false
        dropDownKendaraan.isFocusable = false

        btnSimpan.setOnClickListener {
            if(etNamaWisata.text.toString().isNotEmpty() && dropDownJarak.text.toString().isNotEmpty() &&
                dropDownHarga.text.toString().isNotEmpty() && dropDownKendaraan.text.toString().isNotEmpty()){
                var tampilNamaWisata = etNamaWisata.text.toString()
                var selectedValueJarak = dropDownJarak.text.toString()
                var selectedValueHarga = dropDownHarga.text.toString()
                var selectedValueKendaraan = dropDownKendaraan.text.toString()

                var tampilJarak: Int
                if (selectedValueJarak == "0-10 KM"){
                    tampilJarak = 1
                }else if (selectedValueJarak == "11-50 KM"){
                    tampilJarak = 2
                }else{
                    tampilJarak = 3
                }

                var tampilHarga: Int
                if (selectedValueHarga == "<20.000"){
                    tampilHarga = 1
                }else if (selectedValueHarga == "20.000-100.000"){
                    tampilHarga = 2
                }else{
                    tampilHarga = 3
                }

                var tampilKendaraan: Int
                if (selectedValueKendaraan == "Roda4"){
                    tampilKendaraan = 1
                }else if (selectedValueKendaraan == "Roda2"){
                    tampilKendaraan = 2
                }else{
                    tampilKendaraan = 3
                }

                val output = "Hasil: $tampilNamaWisata $tampilJarak $tampilHarga $tampilKendaraan"

                database.wisatakuDao().insertAllWisata(
                    Wisataku(
                        null,
                        tampilNamaWisata,
                        tampilJarak,
                        tampilHarga,
                        tampilKendaraan
                    )
                )
                etNamaWisata.setText("")
                dropDownJarak.setText("")
                dropDownHarga.setText("")
                dropDownKendaraan.setText("")

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