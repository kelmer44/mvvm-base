package com.combustela.combustela

import android.app.Application
import com.combustela.combustela.data.db.DbModule
import timber.log.Timber

class CombustelaApp : Application() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDependencyGraph()
        setupTimber()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun initDependencyGraph() {
        graph = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .dbModule(DbModule(this))
                .build()
        graph.injectTo(this)
    }
}