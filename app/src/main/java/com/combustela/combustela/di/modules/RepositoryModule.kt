package com.combustela.combustela.di.modules

import com.combustela.combustela.data.network.CompostelaBusesApi
import com.combustela.combustela.data.repository.LineaRepository
import com.combustela.combustela.data.repository.LineaRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {


    @Provides
    @Singleton
    fun provideLineaRepository(compostelaBusesApi: CompostelaBusesApi): LineaRepository {
        return LineaRepositoryImpl(compostelaBusesApi)
    }

}