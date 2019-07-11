package com.combustela.combustela

import android.app.Application
import com.combustela.combustela.data.db.DbModule
import com.combustela.combustela.di.app.ApplicationModule
import com.combustela.combustela.di.app.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class CombustelaApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
    = DaggerApplicationComponent.builder().application(this).build()


    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

}