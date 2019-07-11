package com.combustela.combustela.base

import android.content.Intent
import android.support.v4.app.FragmentActivity
import com.combustela.combustela.ui.detail.DetailActivity
import timber.log.Timber
import javax.inject.Inject

class NavigationController
@Inject constructor(val activity: FragmentActivity){

    fun goDetail(lineaId: String){
        Timber.w("ACTIVITY CLASS IS $activity")
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("LINEA_ID", lineaId)
        activity.startActivity(intent)
    }
}