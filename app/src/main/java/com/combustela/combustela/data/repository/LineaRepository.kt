package com.combustela.combustela.data.repository

import com.combustela.combustela.data.model.remote.LineaBus
import io.reactivex.Single

interface LineaRepository {

    fun getLineas() : Single<List<LineaBus>>
}