package com.example.projectakhir.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kriteria")
data class Kriteria(
    @PrimaryKey(autoGenerate = true )@ColumnInfo(name = "idkriteria") var idkriteria:Int? = null,
    @ColumnInfo(name = "namakriteria") var namakriteria: String?,
    @ColumnInfo(name = "kepentingan") var kepentingan: Int?,
    @ColumnInfo(name = "atribut") var atribut: String?
)