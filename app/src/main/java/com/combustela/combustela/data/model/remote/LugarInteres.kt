package com.combustela.combustela.data.model.remote

data class LugarInteres(val id: Long?,
                        val nombre: String?,
                        val direccion: String?,
                        val imagen: String?,
                        val coordenadas: Coordenada?)

data class Coordenada(val latitud: Long?,
                      val longitud: Long?)
