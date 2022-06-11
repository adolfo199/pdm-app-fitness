package com.example.fitness_app.ui.ejercicios

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitness_app.data.API.RutinasRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class EjerciciosViewModel(private val repository: RutinasRepository) : ViewModel() {
    var myResponse: MutableLiveData<Response<List<Rutina>>> = MutableLiveData()



    fun getRutinas(){
        viewModelScope.launch {
            val response = repository.getallRutinas()
            myResponse.value = response
        }
    }
}