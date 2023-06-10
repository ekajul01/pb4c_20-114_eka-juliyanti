package com.example.projectakhir.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.projectakhir.data.dao.KriteriaDao
import com.example.projectakhir.data.dao.UserDao
import com.example.projectakhir.data.dao.WisatakuDao
import com.example.projectakhir.data.entity.Kriteria
import com.example.projectakhir.data.entity.User
import com.example.projectakhir.data.entity.Wisataku

@Database(entities = [User::class, Wisataku::class, Kriteria::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao
    abstract fun wisatakuDao(): WisatakuDao
    abstract fun kriteriaDao(): KriteriaDao

    companion object{
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            if (instance==null){
                instance = Room.databaseBuilder(context, AppDatabase::class.java, "app-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }
    }
}
