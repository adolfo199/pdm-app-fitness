package com.example.fitness_app.ui.recetas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecetasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Recetas Fragment"
    }
    val text: LiveData<String> = _text
}