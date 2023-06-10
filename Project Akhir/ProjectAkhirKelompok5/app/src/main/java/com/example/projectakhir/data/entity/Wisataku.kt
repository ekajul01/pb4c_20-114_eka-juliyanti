package com.example.projectakhir.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wisataku")
data class Wisataku(
    @PrimaryKey(autoGenerate = true )@ColumnInfo(name = "idwisata") var idwisata:Int? = null,
    @ColumnInfo(name = "namawisata") var namawisata: String?,
    @ColumnInfo(name = "jarakwisata") var jarakwisata: Int?,
    @ColumnInfo(name = "hargawisata") var hargawisata: Int?,
    @ColumnInfo(name = "kendaraan") var kendaraan: Int?
)