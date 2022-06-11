package com.example.fitness_app.data.API

import com.example.fitness_app.core.RetrofitInstance
import com.example.fitness_app.ui.ejercicios.Rutina
import retrofit2.Response

class RutinasRepository {
    suspend fun getallRutinas(): Response<List<Rutina>> {
        return RetrofitInstance.api.getAllRutinas()
    }
}