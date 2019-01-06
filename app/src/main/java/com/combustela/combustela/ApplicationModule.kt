package com.combustela.combustela

import android.app.Application
import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: CombustelaApp) {

    @Provides
    @Singleton
    fun provideApplication(): Application = app


    @Provides
    @Singleton
    fun provideContext(): Context = app.baseContext


    @Provides
    @Singleton
    fun provideResources(): Resources = app.resources

    @Provides
    @Singleton
    fun provideLayoutInflater(context: Context): LayoutInflater {
        return LayoutInflater.from(context)
    }

}