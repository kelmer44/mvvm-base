package com.combustela.combustela.data.model.remote

import java.util.*

data class Incidencia(val id: Long,
                      val stamp: Long,
                      val titulo: String?,
                      val descripcion: String?,
                      val inicio: Date?,
                      val lineas: List<LineaBus>,
                      val paradas: List<ParadaBus>)
