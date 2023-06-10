package com.example.projectakhir.home

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.projectakhir.R
import com.example.projectakhir.data.AppDatabase
import com.example.projectakhir.helper.SharedPreference
import java.text.DecimalFormat

class DaftarPerhitunganFragment : Fragment() {
    private lateinit var cetakOutput1: TextView
    private lateinit var cetakOutput2: TextView
    private lateinit var cetakOutput3: TextView
    private lateinit var cetakOutput4: TextView
    private lateinit var cetakOutput5: TextView
    private lateinit var cetakOutput6: TextView
    private lateinit var cetakOutput7: TextView
    private lateinit var cetakOutput8: TextView
    private lateinit var cetakOutput9: TextView
    private lateinit var cetakOutput10: TextView
    private lateinit var cetakOutput11: TextView
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
        val view = inflater.inflate(R.layout.fragment_daftar_perhitungan, container, false)

        val tampilKriteria = database.kriteriaDao().getCountKriteria()

        cetakOutput1 = view.findViewById(R.id.cetakOutput1)
        cetakOutput2 = view.findViewById(R.id.cetakOutput2)
        cetakOutput3 = view.findViewById(R.id.cetakOutput3)
        cetakOutput4 = view.findViewById(R.id.cetakOutput4)
        cetakOutput5 = view.findViewById(R.id.cetakOutput5)
        cetakOutput6 = view.findViewById(R.id.cetakOutput6)
        cetakOutput7 = view.findViewById(R.id.cetakOutput7)
        cetakOutput8 = view.findViewById(R.id.cetakOutput8)
        cetakOutput9 = view.findViewById(R.id.cetakOutput9)
        cetakOutput10 = view.findViewById(R.id.cetakOutput10)
        cetakOutput11 = view.findViewById(R.id.cetakOutput11)

        if(tampilKriteria == 3){
            val dataWisataDao = database.wisatakuDao()
            val dataKriteriaDao = database.kriteriaDao()

            val alternatif = dataWisataDao.getNamaWisata()
            val idKriteria = dataKriteriaDao.getIDKriteria()
            val kriteria = dataKriteriaDao.getNamaKriteria()
            val kepentingan = dataKriteriaDao.getKepentinganKriteria()
            val atribut = dataKriteriaDao.getAtributKriteria()
            val jarakWisata = dataWisataDao.getJarakWisata()
            val hargaWisata = dataWisataDao.getHargaWisata()
            val kendaraanWisata = dataWisataDao.getKendaraanWisata()

            val dataAlternatifKriteria: MutableList<MutableList<Double>> = mutableListOf()

            for (i in jarakWisata.indices) {
                val sublist: MutableList<Double> = mutableListOf()
                sublist.add(jarakWisata[i].toDouble())
                sublist.add(hargaWisata[i].toDouble())
                sublist.add(kendaraanWisata[i].toDouble())
                dataAlternatifKriteria.add(sublist)
            }

            //menghitung jumlah kepentingan
            var jumlahkepentingan = 0.0
            for (i in kriteria.indices) {
                jumlahkepentingan += kepentingan[i]
            }

            //menghitung bobot kepentingan
            val bobotkepentingan = DoubleArray(kriteria.size)
            for (i in kriteria.indices) {
                bobotkepentingan[i] = kepentingan[i] / jumlahkepentingan
            }

            //normalisasi bobot kriteria
            val pangkat = DoubleArray(kriteria.size)
            for (i in kriteria.indices) {
                if (atribut[i].equals("cost", ignoreCase = true) == true) {
                    pangkat[i] = -1 * bobotkepentingan[i]
                } else { //benefit
                    pangkat[i] = 1 * bobotkepentingan[i]
                }
            }

            //menghitung nilai vector S
            val nilai_s = DoubleArray(alternatif.size)
            var total_s = 0.0
            for (i in alternatif.indices) {
                nilai_s[i] = 1.0
                for (j in kriteria.indices) {
                    nilai_s[i] = nilai_s[i] * Math.pow(dataAlternatifKriteria[i][j], pangkat[j])
                }
                total_s = total_s + nilai_s[i]
            }

            //menghitung nilai vector V
            val hasil_v = DoubleArray(alternatif.size)
            for (i in alternatif.indices) {
                hasil_v[i] = nilai_s[i] / total_s
            }

            //membuat perangkingan
            val alternatifrangking = arrayOfNulls<String>(alternatif.size)
            val hasilrangking = DoubleArray(alternatif.size)
            for (i in alternatif.indices) {
                hasilrangking[i] = hasil_v[i]
                alternatifrangking[i] = alternatif[i]
            }
            for (i in alternatif.indices) {
                for (j in i until alternatif.size) {
                    if (hasilrangking[j] > hasilrangking[i]) {
                        val tmphasil = hasilrangking[i]
                        val tmpalternatif = alternatifrangking[i]
                        hasilrangking[i] = hasilrangking[j]
                        alternatifrangking[i] = alternatifrangking[j]
                        hasilrangking[j] = tmphasil
                        alternatifrangking[j] = tmpalternatif
                    }
                }
            }

            //format decimal agar tampil 4 angka dibelakang koma
            val decimalFormat = DecimalFormat("#.####")

            cetakOutput1.setText("Daftar Alternatif dan Nilai Kriteria")

            //membuat tabel daftar alternatif kriteria
            val table1: MutableList<MutableList<Any>> = mutableListOf()
            table1.add(mutableListOf("Alternatif", "Jarak", "Harga", "Kendaraan"))

            for (i in alternatif.indices) {
                val row: MutableList<Any> = mutableListOf()
                row.add(alternatif[i])
                row.add(jarakWisata[i])
                row.add(hargaWisata[i])
                row.add(kendaraanWisata[i])
                table1.add(row)
            }
            // Menampilkan tabel dengan garis
            val columnWidths1 = mutableListOf<Int>()
            for (columnIndex1 in 0 until table1[0].size) {
                var maxWidth1 = table1[0][columnIndex1].toString().length
                for (rowIndex1 in 1 until table1.size) {
                    val cellWidth1 = table1[rowIndex1][columnIndex1].toString().length
                    if (cellWidth1 > maxWidth1) {
                        maxWidth1 = cellWidth1
                    }
                }
                columnWidths1.add(maxWidth1)
            }

            val horizontalLine1 = "+${"-".repeat(columnWidths1.sum() + columnWidths1.size * 3 - 1)}+"
            cetakOutput2.append("$horizontalLine1\n")
            for (row1 in table1) {
                for (columnIndex1 in row1.indices) {
                    val cellValue1 = row1[columnIndex1].toString()
                    val cellWidth1 = columnWidths1[columnIndex1]
                    val padding1 = " ".repeat(cellWidth1 - cellValue1.length)
                    cetakOutput2.append("| $cellValue1$padding1 ")
                }
                cetakOutput2.append("|\n")
                cetakOutput2.append("$horizontalLine1\n")
            }

            cetakOutput3.setText("Daftar Kriteria")

            //membuat tabel daftar kriteria
            val table2: MutableList<MutableList<Any>> = mutableListOf()
            table2.add(mutableListOf("Id Kriteria","Kriteria"))

            for (i in kriteria.indices) {
                val row2: MutableList<Any> = mutableListOf()
                row2.add(idKriteria[i])
                row2.add(kriteria[i])
                table2.add(row2)
            }
            // Menampilkan tabel dengan garis
            val columnWidths2 = mutableListOf<Int>()
            for (columnIndex2 in 0 until table2[0].size) {
                var maxWidth2 = table2[0][columnIndex2].toString().length
                for (rowIndex2 in 1 until table2.size) {
                    val cellWidth2 = table2[rowIndex2][columnIndex2].toString().length
                    if (cellWidth2 > maxWidth2) {
                        maxWidth2 = cellWidth2
                    }
                }
                columnWidths2.add(maxWidth2)
            }

            val horizontalLine2 = "+${"-".repeat(columnWidths2.sum() + columnWidths2.size * 3 - 1)}+"
            cetakOutput4.append("$horizontalLine2\n")
            for (row2 in table2) {
                for (columnIndex2 in row2.indices) {
                    val cellValue2 = row2[columnIndex2].toString()
                    val cellWidth2 = columnWidths2[columnIndex2]
                    val padding2 = " ".repeat(cellWidth2 - cellValue2.length)
                    cetakOutput4.append("| $cellValue2$padding2 ")
                }
                cetakOutput4.append("|\n")
                cetakOutput4.append("$horizontalLine2\n")
            }

            cetakOutput5.setText("Normalisasi Bobot Kriteria")

            //membuat tabel normalisasi kriteria
            val table3: MutableList<MutableList<Any>> = mutableListOf()
            table3.add(mutableListOf("ID", "Nilai", "Bobot", "Pangkat"))

            for (i in kriteria.indices) {
                val row3: MutableList<Any> = mutableListOf()
                row3.add(idKriteria[i])
                row3.add(kepentingan[i])
                row3.add(decimalFormat.format(bobotkepentingan[i]))
                row3.add(decimalFormat.format(pangkat[i]))
                table3.add(row3)
            }
            // Menampilkan tabel dengan garis
            val columnWidths3 = mutableListOf<Int>()
            for (columnIndex3 in 0 until table3[0].size) {
                var maxWidth3 = table3[0][columnIndex3].toString().length
                for (rowIndex3 in 1 until table3.size) {
                    val cellWidth3 = table3[rowIndex3][columnIndex3].toString().length
                    if (cellWidth3 > maxWidth3) {
                        maxWidth3 = cellWidth3
                    }
                }
                columnWidths3.add(maxWidth3)
            }

            val horizontalLine3 = "+${"-".repeat(columnWidths3.sum() + columnWidths3.size * 3 - 1)}+"
            cetakOutput6.append("$horizontalLine3\n")
            for (row3 in table3) {
                for (columnIndex3 in row3.indices) {
                    val cellValue3 = row3[columnIndex3].toString()
                    val cellWidth3 = columnWidths3[columnIndex3]
                    val padding3 = " ".repeat(cellWidth3 - cellValue3.length)
                    cetakOutput6.append("| $cellValue3$padding3 ")
                }
                cetakOutput6.append("|\n")
                cetakOutput6.append("$horizontalLine3\n")
            }

            cetakOutput7.setText("Total nilai kepentingan = ${jumlahkepentingan.toInt()}\n")

            cetakOutput8.setText("Menghitung nilai vector S")

            //membuat tabel vector s
            val table4: MutableList<MutableList<Any>> = mutableListOf()
            table4.add(mutableListOf("Nama Alternatif", "Vector S"))

            for (i in alternatif.indices) {
                val row4: MutableList<Any> = mutableListOf()
                row4.add(alternatif[i])
                row4.add(decimalFormat.format(nilai_s[i])) // nilai s
                table4.add(row4)
            }
            //Menampilkan tabel dengan garis
            val columnWidths4 = mutableListOf<Int>()
            for (columnIndex4 in 0 until table4[0].size) {
                var maxWidth4 = table4[0][columnIndex4].toString().length
                for (rowIndex4 in 1 until table4.size) {
                    val cellWidth4 = table4[rowIndex4][columnIndex4].toString().length
                    if (cellWidth4 > maxWidth4) {
                        maxWidth4 = cellWidth4
                    }
                }
                columnWidths4.add(maxWidth4)
            }

            val horizontalLine4 = "+${"-".repeat(columnWidths4.sum() + columnWidths4.size * 3 - 1)}+"
            cetakOutput9.append("$horizontalLine4\n")
            for (row4 in table4) {
                for (columnIndex4 in row4.indices) {
                    val cellValue4 = row4[columnIndex4].toString()
                    val cellWidth4 = columnWidths4[columnIndex4]
                    val padding4 = " ".repeat(cellWidth4 - cellValue4.length)
                    cetakOutput9.append("| $cellValue4$padding4 ")
                }
                cetakOutput9.append("|\n")
                cetakOutput9.append("$horizontalLine4\n")
            }

            cetakOutput10.setText("Hasil Perangkingan (Vector V)")

            //membuat tabel perangkingan
            val table: MutableList<MutableList<Any>> = mutableListOf()
            table.add(mutableListOf("Ranking", "Nama Alternatif", "Hasil Ranking"))

            for (i in alternatifrangking.indices) {
                val row: MutableList<Any> = mutableListOf()
                row.add(i + 1) // Ranking
                alternatifrangking[i]?.let { row.add(it) } // Nama Alternatif
                row.add(decimalFormat.format(hasilrangking[i])) // Hasil Ranking
                table.add(row)
            }
            // Menampilkan tabel dengan garis
            val columnWidths = mutableListOf<Int>()
            for (columnIndex in 0 until table[0].size) {
                var maxWidth = table[0][columnIndex].toString().length
                for (rowIndex in 1 until table.size) {
                    val cellWidth = table[rowIndex][columnIndex].toString().length
                    if (cellWidth > maxWidth) {
                        maxWidth = cellWidth
                    }
                }
                columnWidths.add(maxWidth)
            }

            val horizontalLine = "+${"-".repeat(columnWidths.sum() + columnWidths.size * 3 - 1)}+"
            cetakOutput11.append("$horizontalLine\n")
            for (row in table) {
                for (columnIndex in row.indices) {
                    val cellValue = row[columnIndex].toString()
                    val cellWidth = columnWidths[columnIndex]
                    val padding = " ".repeat(cellWidth - cellValue.length)
                    cetakOutput11.append("| $cellValue$padding ")
                }
                cetakOutput11.append("|\n")
                cetakOutput11.append("$horizontalLine\n")
            }
        }else{
            cetakOutput1.gravity = Gravity.CENTER
            cetakOutput1.setText("Jumlah Kriteria Harus 3")
        }

        return view
    }
}
