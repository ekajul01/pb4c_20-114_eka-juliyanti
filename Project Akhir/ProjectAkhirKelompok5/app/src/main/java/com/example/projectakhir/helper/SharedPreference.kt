package com.example.projectakhir.helper

import android.content.Context
import android.content.SharedPreferences

class SharedPreference(activity: Context) {
    val wisatabro = "Wisata"
    val login = "Login"
    val myPref = "Main_Pref"
    val emailku = "Email"
    val sharedPreference: SharedPreferences

    init {
        sharedPreference = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE)
    }

    fun setStatusLogin(status: Boolean){
        sharedPreference.edit().putBoolean(login, status).apply()
    }

    fun setDataLogin(dataku: String){
        sharedPreference.edit().putString(emailku, dataku).apply()
    }

    fun setDataWisata(wisatakuu: String){
        sharedPreference.edit().putString(wisatabro, wisatakuu).apply()
    }

    fun getDataWisata(): String?{
        return sharedPreference.getString(emailku, "")
    }

    fun getStatusLogin():Boolean{
        return sharedPreference.getBoolean(login, false)
    }

    fun getDataLogin(): String? {
        return sharedPreference.getString(emailku, "")
    }
}