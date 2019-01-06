package com.combustela.combustela.data.network

import com.combustela.combustela.data.model.remote.Incidencia
import com.combustela.combustela.data.model.remote.LineaBus
import com.combustela.combustela.data.model.remote.LugarInteres
import io.reactivex.Single
import retrofit2.http.GET

interface CompostelaBusesApi {

    @GET("lineas")
    fun getLineas(): Single<List<LineaBus>>

    @GET("incidencias")
    fun getIncidencias(): Single<List<Incidencia>>

    @GET("lugares-interes")
    fun getLugaresInteres(): Single<List<LugarInteres>>
}