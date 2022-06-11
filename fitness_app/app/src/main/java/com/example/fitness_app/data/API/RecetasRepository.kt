package com.example.fitness_app.data.API

import com.example.fitness_app.core.RetrofitInstance
import com.example.fitness_app.ui.recetas.Recetas
import retrofit2.Response

class RecetasRepository {

    suspend fun getallRecetas(): Response<List<Recetas>> {
        return RetrofitInstance.api.getAllRecetas()
    }
}