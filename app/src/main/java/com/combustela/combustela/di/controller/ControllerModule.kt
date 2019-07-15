package com.combustela.combustela.di.controller

import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
class ControllerModule {

    @Provides
    @ControllerScope
    fun layoutInflater(activity: FragmentActivity) = activity.layoutInflater
}