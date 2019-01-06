package com.combustela.combustela.di.modules

import com.combustela.combustela.data.network.CompostelaBusesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun providesBusesApi(retrofit: Retrofit) = retrofit.create(CompostelaBusesApi::class.java)
}