package com.example.fitness_app.data.API

import com.example.fitness_app.ui.ejercicios.Rutina
import com.example.fitness_app.ui.recetas.Recetas
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("recetas")
    suspend fun getAllRecetas(): Response<List<Recetas>>

    @GET("rutinas")
    suspend fun getAllRutinas(): Response<List<Rutina>>
}