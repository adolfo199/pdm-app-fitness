package com.example.fitness_app.ui.recetas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness_app.data.API.RecetasRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class RecetasViewModel(private val repository: RecetasRepository) : ViewModel() {
    var myResponse:MutableLiveData<Response<List<Recetas>>> = MutableLiveData()



    fun getReceta(){
        viewModelScope.launch {
            val response = repository.getallRecetas()
            myResponse.value = response
        }
    }
}