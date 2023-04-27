package com.example.tugaspraktikum3_4.data.dao

import androidx.room.*
import com.example.tugaspraktikum3_4.data.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE nim IN (:nimIds)")
    fun loadAllByIds(nimIds: IntArray): List<User>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE nim = :nim")
    fun get(nim: String?) : User

    @Update
    fun update(user: User)

}