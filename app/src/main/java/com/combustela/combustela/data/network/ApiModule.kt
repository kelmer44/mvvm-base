package com.combustela.combustela.data.network

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