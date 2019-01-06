package com.combustela.combustela.di.controller

import android.content.Context
import android.support.v4.app.FragmentActivity
import com.combustela.combustela.base.NavigationController
import dagger.Module
import dagger.Provides
import kotlin.math.acos

@Module
class ControllerModule(val activity: FragmentActivity) {


    @Provides
    @ControllerScope
    fun providesContext(): Context = activity

    @Provides
    @ControllerScope
    fun activity() = activity


    @Provides
    @ControllerScope
    fun layoutInflater() = activity.layoutInflater


    @Provides
    @ControllerScope
    fun provideNavigationController(activity: FragmentActivity) = NavigationController(activity)

}