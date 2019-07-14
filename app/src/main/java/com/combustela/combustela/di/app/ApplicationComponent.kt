package com.combustela.combustela.di.app

import android.app.Application
import com.combustela.combustela.CombustelaApp
import com.combustela.combustela.data.db.DbModule
import com.combustela.combustela.di.activity.ActivityBinder
import com.combustela.combustela.di.modules.ApiModule
import com.combustela.combustela.di.modules.RepositoryModule
import com.combustela.combustela.di.modules.NetModule
import dagger.BindsInstance
import dagger.Component
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

    @Component.Factory
    interface Factory {
     fun newApplicationComponent(@BindsInstance app: Application): ApplicationComponent
    }
}