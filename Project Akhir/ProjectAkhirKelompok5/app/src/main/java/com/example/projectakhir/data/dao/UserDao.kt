package com.example.projectakhir.data.dao

import androidx.room.*
import com.example.projectakhir.data.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE email IN (:emailIds)")
    fun loadAllByIds(emailIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun login(email: String, password: String?): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE email = :email")
    fun getUser(email: String?) : User

    @Update
    fun update(user: User)

}