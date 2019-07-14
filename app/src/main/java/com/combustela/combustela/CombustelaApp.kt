package com.combustela.combustela

import com.combustela.combustela.di.app.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class CombustelaApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
    = DaggerApplicationComponent.factory().newApplicationComponent(this)


    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

}