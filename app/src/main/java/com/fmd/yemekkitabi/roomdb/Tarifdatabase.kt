package com.fmd.yemekkitabi.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fmd.yemekkitabi.model.tarif

@Database(entities = [tarif::class], version =1)
abstract class Tarifdatabase:RoomDatabase() {
    abstract fun tarifDao():TarifDAO
}