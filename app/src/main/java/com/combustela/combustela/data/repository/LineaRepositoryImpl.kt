package com.combustela.combustela.data.repository

import com.combustela.combustela.data.model.remote.LineaBus
import com.combustela.combustela.data.network.CompostelaBusesApi
import io.reactivex.Single

class LineaRepositoryImpl(val compostelaBusesApi: CompostelaBusesApi ): LineaRepository {
    override fun getLineas(): Single<List<LineaBus>> {
        return compostelaBusesApi.getLineas()
    }
}