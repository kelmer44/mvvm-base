package com.combustela.combustela.ui

import android.arch.lifecycle.MutableLiveData
import com.combustela.combustela.base.mvvm.BaseViewModel
import com.combustela.combustela.data.model.remote.LineaBus
import com.combustela.combustela.data.repository.LineaRepository
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MainViewModel
@Inject constructor(val lineaRepository: LineaRepository) : BaseViewModel() {


    val lineas: MutableLiveData<List<LineaBus>> = MutableLiveData()

    val errores: MutableLiveData<String> = MutableLiveData()
    fun getLineas() {
        lineaRepository.getLineas()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribeBy(onError = {
                    errores.value = "Error"
                },
                        onSuccess = {
                            lineas.value = it
                        })
                .addTo(disposables)

    }

}
