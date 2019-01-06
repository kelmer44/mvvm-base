package com.combustela.combustela.di.controller

import com.combustela.combustela.ui.MainActivity
import dagger.Subcomponent


@ControllerScope
@Subcomponent(
        modules = [
            ControllerModule::class
        ]
)
interface ControllerComponent {
    fun inject(dashboardActivity: MainActivity)
}