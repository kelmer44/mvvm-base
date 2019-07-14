package com.combustela.combustela.ui

import android.support.v4.app.FragmentActivity
import com.combustela.combustela.di.controller.ControllerScope
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {
  @Binds @ControllerScope
  abstract fun bindsActivity(mainActivity: MainActivity): FragmentActivity
}
