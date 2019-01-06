package com.combustela.combustela

import android.app.Application
import com.combustela.combustela.data.db.DbModule
import com.combustela.combustela.di.app.ApplicationModule
import com.combustela.combustela.di.app.DaggerApplicationComponent
import timber.log.Timber

class CombustelaApp : Application() {



    val applicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .dbModule(DbModule(this))
                .build()
    }



    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

}