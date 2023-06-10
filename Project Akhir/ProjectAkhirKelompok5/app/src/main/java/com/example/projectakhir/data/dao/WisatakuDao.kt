package com.example.projectakhir.data.dao

import androidx.room.*
import com.example.projectakhir.data.entity.DataWisata
import com.example.projectakhir.data.entity.Wisataku

@Dao
interface WisatakuDao {
    @Query("SELECT * FROM wisataku")
    fun getAllWisata(): List<Wisataku>

    @Query("SELECT namawisata FROM wisataku")
    fun getNamaWisata(): List<String>

    @Query("SELECT jarakwisata, hargawisata, kendaraan FROM wisataku")
    fun getDataWisata(): List<DataWisata>

    @Query("SELECT jarakwisata FROM wisataku")
    fun getJarakWisata(): List<Int>

    @Query("SELECT hargawisata FROM wisataku")
    fun getHargaWisata(): List<Int>

    @Query("SELECT kendaraan FROM wisataku")
    fun getKendaraanWisata(): List<Int>

    @Query("SELECT * FROM wisataku WHERE idwisata IN (:wisataIds)")
    fun loadAllByIdsWisata(wisataIds: IntArray): List<Wisataku>

    @Insert
    fun insertAllWisata(vararg wisatakus: Wisataku)

    @Delete
    fun deleteWisata(wisatakus: Wisataku)

    @Query("SELECT * FROM wisataku WHERE idwisata = :idwisata")
    fun getWisata(idwisata: String?) : Wisataku

    @Update
    fun updateWisata(wisatakus: Wisataku)
}