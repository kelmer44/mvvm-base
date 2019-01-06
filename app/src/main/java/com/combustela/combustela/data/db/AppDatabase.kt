package com.combustela.combustela.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(
        entities = [],
        version = 1)
abstract class AppDatabase : RoomDatabase() {
//    abstract fun localParcelDao(): LocalParcelDao
}