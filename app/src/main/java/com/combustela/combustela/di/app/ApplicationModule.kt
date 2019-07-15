package com.combustela.combustela.di.app

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.combustela.combustela.base.net.NetworkInteractor
import com.combustela.combustela.base.net.NetworkInteractorImpl
import com.combustela.combustela.base.scheduler.AppSchedulerProvider
import com.combustela.combustela.base.scheduler.SchedulerProvider
import com.combustela.combustela.di.viewModel.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    @Provides
    fun provideNetworkInteractor(networkInteractor: NetworkInteractorImpl): NetworkInteractor = networkInteractor


    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

    @Provides
    fun provideConnectivityManager(context: Application): ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager


}