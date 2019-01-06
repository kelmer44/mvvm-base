package com.combustela.combustela.base.mvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import javax.inject.Inject

abstract class BaseFragment<E : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    protected lateinit var viewModel: E
    abstract val viewModelClass : Class<E>
    abstract val layoutId: Int


    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(layoutId, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
        loadUp(savedInstanceState)
    }

    abstract fun inject()

    abstract fun loadUp(savedInstanceState: Bundle?)

    val baseActivity by lazy { activity as? BaseActivity<*> }


}