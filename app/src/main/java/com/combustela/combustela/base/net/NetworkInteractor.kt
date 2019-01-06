package com.combustela.combustela.base.net

import io.reactivex.Completable

interface NetworkInteractor {

    fun hasNetworkConnection(): Boolean

    fun hasNetworkConnectionCompletable(): Completable

    class NetworkUnavailableException : Throwable("No network available!")
}