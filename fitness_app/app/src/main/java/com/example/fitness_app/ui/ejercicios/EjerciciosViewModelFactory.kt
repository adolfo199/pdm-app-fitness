package com.example.fitness_app.ui.ejercicios

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitness_app.data.API.RutinasRepository

class EjerciciosViewModelFactory(private val repository: RutinasRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EjerciciosViewModel(repository) as T
    }
}