package com.combustela.combustela.di.controller

import com.combustela.combustela.ui.MainActivity
import com.combustela.combustela.ui.detail.DetailActivity
import dagger.Subcomponent


@ControllerScope
@Subcomponent(
        modules = [
            ControllerModule::class
        ]
)
interface ControllerComponent {
    fun inject(dashboardActivity: MainActivity)
    fun inject(dashboardActivity: DetailActivity)
}