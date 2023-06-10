package com.example.projectakhir.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User (
    @PrimaryKey @ColumnInfo(name = "email") var email:String,
    @ColumnInfo(name = "nama") var nama: String?,
    @ColumnInfo(name = "password") var password: String?,
)