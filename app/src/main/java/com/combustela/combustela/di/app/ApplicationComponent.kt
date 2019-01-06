package com.combustela.combustela.di.app

import com.combustela.combustela.CombustelaApp
import com.combustela.combustela.data.db.DbModule
import com.combustela.combustela.di.modules.ApiModule
import com.combustela.combustela.di.modules.RepositoryModule
import com.combustela.combustela.di.controller.ControllerComponent
import com.combustela.combustela.di.controller.ControllerModule
import com.combustela.combustela.di.modules.NetModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ApplicationModule::class,
        DbModule::class,
        NetModule::class,
        ApiModule::class,
        RepositoryModule::class
        ]
)
interface ApplicationComponent {

    fun inject(app: CombustelaApp)
    fun plus(controllerModule: ControllerModule): ControllerComponent
}