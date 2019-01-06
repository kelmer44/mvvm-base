package com.combustela.combustela.base

import android.support.v4.app.FragmentActivity
import timber.log.Timber
import javax.inject.Inject

class NavigationController
@Inject constructor(val activity: FragmentActivity){

    fun verLinea(lineaId: String){
        Timber.w("ACTIVITY CLASS IS $activity")
    }
}