package com.combustela.combustela.base.net

import android.net.ConnectivityManager
import io.reactivex.Completable
import javax.inject.Inject

class NetworkInteractorImpl @Inject constructor(
        private val connectivityManager: ConnectivityManager
) : NetworkInteractor {
    override fun hasNetworkConnection(): Boolean =
            connectivityManager.activeNetworkInfo?.isConnectedOrConnecting ?: false

    override fun hasNetworkConnectionCompletable(): Completable =
            if(hasNetworkConnection()){
                Completable.complete()
            } else {
                Completable.error { NetworkInteractor.NetworkUnavailableException() }
            }
}