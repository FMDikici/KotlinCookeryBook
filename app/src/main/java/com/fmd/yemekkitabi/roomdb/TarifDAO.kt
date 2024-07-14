package com.fmd.yemekkitabi.roomdb

import androidx.core.location.LocationRequestCompat.Quality
import androidx.room.Query
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Dao
import com.fmd.yemekkitabi.model.tarif
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable

@Dao
interface TarifDAO {

    @Query("SELECT * FROM Tarif")
    fun getAll(): Flowable<List<tarif>>

    @Query("SELECT * FROM tarif WHERE id=:id")
    fun  findById(id:Int):Flowable<tarif>

    @Insert
    fun insert(tarif:tarif):Completable

    @Delete
    fun delete(tarif: tarif):Completable

    companion object {
        fun insert(tarif: tarif) {

        }
    }
}