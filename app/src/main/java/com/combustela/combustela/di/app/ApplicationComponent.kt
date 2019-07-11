package com.combustela.combustela.di.app

import com.combustela.combustela.CombustelaApp
import com.combustela.combustela.data.db.DbModule
import com.combustela.combustela.di.activity.ActivityBinder
import com.combustela.combustela.di.modules.ApiModule
import com.combustela.combustela.di.modules.RepositoryModule
import com.combustela.combustela.di.controller.ControllerComponent
import com.combustela.combustela.di.controller.ControllerModule
import com.combustela.combustela.di.modules.NetModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBinder::class,
            ApplicationModule::class,
            DbModule::class,
            NetModule::class,
            ApiModule::class,
            RepositoryModule::class
        ]
)
interface ApplicationComponent : AndroidInjector<CombustelaApp> {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent
        @BindsInstance
        fun application(application: CombustelaApp) : Builder
    }
}