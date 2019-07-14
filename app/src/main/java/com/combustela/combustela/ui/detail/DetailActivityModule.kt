package com.combustela.combustela.ui.detail

import android.support.v4.app.FragmentActivity
import com.combustela.combustela.di.controller.ControllerScope
import dagger.Binds
import dagger.Module

@Module
abstract class DetailActivityModule {

  @Binds @ControllerScope
  abstract fun bindsActivity(detailActivity: DetailActivity): FragmentActivity
}