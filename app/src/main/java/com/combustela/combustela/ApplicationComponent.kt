package com.combustela.combustela

import com.combustela.combustela.data.db.DbModule
import com.combustela.combustela.data.network.ApiModule
import com.combustela.combustela.data.repository.RepositoryModule
import com.combustela.combustela.di.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NetModule::class,
    DbModule::class,
    RepositoryModule::class,
    ApiModule::class
])
interface ApplicationComponent {

    fun injectTo(app: CombustelaApp)


}