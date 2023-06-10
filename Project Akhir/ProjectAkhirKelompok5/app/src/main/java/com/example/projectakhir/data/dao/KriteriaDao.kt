package com.example.projectakhir.data.dao

import androidx.room.*
import com.example.projectakhir.data.entity.Kriteria

@Dao
interface KriteriaDao {
    @Query("SELECT * FROM kriteria")
    fun getAllKriteria(): List<Kriteria>

    @Query("SELECT COUNT(*) FROM kriteria")
    fun getCountKriteria(): Int

    @Query("SELECT namakriteria FROM kriteria")
    fun getNamaKriteria(): List<String>

    @Query("SELECT idkriteria FROM kriteria")
    fun getIDKriteria(): List<Int>

    @Query("SELECT kepentingan FROM kriteria")
    fun getKepentinganKriteria(): List<Int>

    @Query("SELECT atribut FROM kriteria")
    fun getAtributKriteria(): List<String>

    @Query("SELECT * FROM kriteria WHERE idkriteria IN (:kriteriaIds)")
    fun loadAllByIdsKriteria(kriteriaIds: IntArray): List<Kriteria>

    @Insert
    fun insertAllKriteria(vararg kriteria: Kriteria)

    @Delete
    fun deleteKriteria(kriteria: Kriteria)

    @Query("SELECT * FROM kriteria WHERE idkriteria = :idkriteria")
    fun getKriteria(idkriteria: Int?): Kriteria

    @Update
    fun updateKriteria(kriteria: Kriteria)
}

