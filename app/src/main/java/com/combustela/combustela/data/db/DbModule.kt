package com.combustela.combustela.data.db

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule(val context: Context) {

    @Provides
    @Singleton
    fun provideAppDatabase() : AppDatabase {
        return Room.databaseBuilder(context,
                AppDatabase::class.java, "combustela-database")
                .build()
    }

}