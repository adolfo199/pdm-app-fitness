package com.example.fitness_app.ui.recetas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitness_app.data.API.RecetasRepository

class RecetasViewModelFactory(private val repository: RecetasRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RecetasViewModel(repository) as T
    }

}