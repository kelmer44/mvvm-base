package com.combustela.combustela.base

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import com.combustela.combustela.util.NetworkInteractor
import com.combustela.combustela.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

abstract class RxViewModel : ViewModel() {

    protected val disposables: CompositeDisposable = CompositeDisposable()

    @Inject
    lateinit var networkInteractor: NetworkInteractor
    @Inject
    lateinit var schedulerProvider: SchedulerProvider

    @CallSuper
    fun onDestroy() {
        clearSubscriptions()
    }

    private fun clearSubscriptions() {
        disposables.clear()
        //disposables.dispose()
    }

    fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        clearSubscriptions()
    }


    @CallSuper
    open fun cancel(){
        clearSubscriptions()
    }

}