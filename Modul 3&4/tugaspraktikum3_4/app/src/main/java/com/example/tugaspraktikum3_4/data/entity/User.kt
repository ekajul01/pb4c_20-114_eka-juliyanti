package com.example.tugaspraktikum3_4.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey @ColumnInfo(name = "nim") var nim:String,
    @ColumnInfo(name = "full_name") var fullName: String?,
    @ColumnInfo(name = "email") var email: String?,
    @ColumnInfo(name = "phone") var phone: String?,
    @ColumnInfo(name = "alamat") var alamat: String?
)