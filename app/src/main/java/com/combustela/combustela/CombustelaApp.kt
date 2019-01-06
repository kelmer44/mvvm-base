package com.combustela.combustela

import android.app.Application
import com.combustela.combustela.data.db.DbModule
import timber.log.Timber

class CombustelaApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

}