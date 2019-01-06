package com.combustela.combustela.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.combustela.combustela.CombustelaApp
import com.combustela.combustela.R
import com.combustela.combustela.base.mvvm.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity<MainViewModel>() {
    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override val layoutId: Int = R.layout.activity_main

    override fun loadUp(savedInstanceState: Bundle?) {
        Timber.w("SUP")
        navigationController.verLinea("safsdf")
    }

    override fun inject() {
        component.inject(this)
    }

}
