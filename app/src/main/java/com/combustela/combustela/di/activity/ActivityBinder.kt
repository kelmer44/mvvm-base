package com.combustela.combustela.di.activity

import com.combustela.combustela.di.controller.ControllerModule
import com.combustela.combustela.di.controller.ControllerScope
import com.combustela.combustela.ui.MainActivity
import com.combustela.combustela.ui.detail.DetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder {

    @ControllerScope
    @ContributesAndroidInjector(modules = [ControllerModule::class])
    abstract fun contributesMainActivity(): MainActivity

    @ControllerScope
    @ContributesAndroidInjector(modules = [ControllerModule::class])
    abstract fun contributesDetailActivity(): DetailActivity
}