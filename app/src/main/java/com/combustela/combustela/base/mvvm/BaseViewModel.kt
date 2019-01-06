package com.combustela.combustela.base.mvvm

import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import com.combustela.combustela.base.net.NetworkInteractor
import com.combustela.combustela.base.scheduler.SchedulerProvider
import io.reactivex.Completable
import io.reactivex.SingleSource
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.reactivestreams.Publisher
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {

    @Inject
    lateinit var schedulerProvider: SchedulerProvider
    @Inject
    lateinit var networkInteractor: NetworkInteractor


    val disposables: CompositeDisposable = CompositeDisposable()

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        clearSubscriptions()
    }

    private fun clearSubscriptions() {
        disposables.clear()
    }

    fun addDisponable(disposable: Disposable){
        disposables.add(disposable)
    }

    fun <T> withNetwork(p: Publisher<T>) =
            networkInteractor.hasNetworkConnectionCompletable().andThen(p)


    fun <T> withNetwork(p: SingleSource<T>) =
            networkInteractor.hasNetworkConnectionCompletable().andThen(p)

    fun withNetwork(c: Completable) =
            networkInteractor.hasNetworkConnectionCompletable().andThen(c)

}