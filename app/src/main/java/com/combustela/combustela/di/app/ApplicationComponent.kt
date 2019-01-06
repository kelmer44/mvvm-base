package com.combustela.combustela.di.app

import com.combustela.combustela.CombustelaApp
import com.combustela.combustela.data.db.DbModule
import com.combustela.combustela.di.controller.ControllerComponent
import com.combustela.combustela.di.controller.ControllerModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [ApplicationModule::class,
        DbModule::class,
        ]
)
interface ApplicationComponent {

    fun inject(app: CombustelaApp)
    fun plus(controllerModule: ControllerModule): ControllerComponent
}