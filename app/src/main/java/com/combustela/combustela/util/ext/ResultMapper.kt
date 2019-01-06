package com.combustela.combustela.util.ext

import com.combustela.combustela.base.scheduler.SchedulerProvider
import com.combustela.combustela.util.livedata.Result
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import org.intellij.lang.annotations.Flow
import retrofit2.HttpException


fun <T> Flowable<T>.toResult(schedulerProvider: SchedulerProvider) : Flowable<Result<T>> {
    return compose {  item ->
        item
                .map { Result.success(it) }
                .onErrorReturn {
                    e -> Result.failure(e)
                }
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .startWith(Result.inProgress())
    }
}

fun <T> Single<T>.toResult(schedulerProvider: SchedulerProvider): Observable<Result<T>> {
    return toObservable().toResult(schedulerProvider)
}


fun <T> Single<T>.ioUi(schedulerProvider: SchedulerProvider): Single<T> {
    return this.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
}

fun <T> Observable<T>.ioUi(schedulerProvider: SchedulerProvider): Observable<T> {
    return this.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
}

fun <T> Flowable<T>.ioUi(schedulerProvider: SchedulerProvider): Flowable<T> {
    return this.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
}

fun Completable.ioUi(schedulerProvider: SchedulerProvider): Completable {
    return this.subscribeOn(schedulerProvider.io()).observeOn(schedulerProvider.ui())
}


fun <T> Observable<T>.toResult(schedulerProvider: SchedulerProvider): Observable<Result<T>> {
    return compose { item ->
        item
                .map { Result.success(it) }
                .onErrorReturn { e ->
                        Result.failure(e)
                }
                .ioUi(schedulerProvider)
                .startWith(Result.inProgress())
    }
}