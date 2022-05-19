package com.example.fitness_app.ui.ejercicios

import java.io.Serializable

class Rutina(
    val name:String,
    val image:Int,
    val ejercicios:List<Ejercicio>,
    val calorias:Int,
    val duracion:Int,
              ) : Serializable