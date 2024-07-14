package com.fmd.yemekkitabi.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class tarif(

    @ColumnInfo(name="isim")
    var isim :String,

    @ColumnInfo(name="malzeme")
    var malzeme :String,

    @ColumnInfo(name="gorsel")
    var gorsel :ByteArray,
) {
    @PrimaryKey(autoGenerate = true)
    var id=0
}




