package com.combustela.combustela.ui

import android.arch.lifecycle.MutableLiveData
import com.combustela.combustela.base.mvvm.BaseViewModel
import com.combustela.combustela.data.model.remote.LineaBus
import com.combustela.combustela.data.repository.LineaRepository
import com.combustela.combustela.util.ext.toResult
import com.combustela.combustela.util.livedata.Result
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainViewModel
@Inject constructor(val lineaRepository: LineaRepository) : BaseViewModel() {


    val lineas: MutableLiveData<Result<List<LineaBus>>> = MutableLiveData()

    fun getLineas() {
        lineaRepository.getLineas()
                .toResult(schedulerProvider)
                .subscribeBy(onNext = {
                    lineas.value = it
                })
                .addTo(disposables)

    }

}
