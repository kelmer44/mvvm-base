package com.combustela.combustela.base.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v7.app.AppCompatActivity
import com.combustela.combustela.CombustelaApp
import com.combustela.combustela.base.NavigationController
import com.combustela.combustela.di.controller.ControllerModule
import javax.inject.Inject

abstract class BaseActivity<E : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: E

    abstract val viewModelClass: Class<E>
    abstract val layoutId: Int

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val component by lazy {
        (application as CombustelaApp)
                .applicationComponent
                .plus(
                        ControllerModule(this)
                )
    }


    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        setContentView(layoutId)
        loadUp(savedInstanceState)
    }

    abstract fun loadUp(savedInstanceState: Bundle?)
    abstract fun inject()




}