package com.veyselakbalik.btkbesinlerkitabi.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.veyselakbalik.btkbesinlerkitabi.model.Besin

@Dao
interface BesinDAO {
    @Insert
    suspend fun insertAll(vararg besin : Besin) : List<Long>

    // Insert -> Room, insert into
    // suspend -> coroutine scope
    // vararg -> birden fazla ve istediğimiz sayıda besin
    // List<Long> -> long , idler

    @Query("SELECT * FROM besin")
    suspend fun getAllBesin() : List<Besin>

    @Query("SELECT * FROM besin WHERE uuid = :besinId")
    suspend fun getBesin(besinId : Int) : Besin

    @Query("DELETE FROM besin")
    suspend fun deleteAllBesin()
}