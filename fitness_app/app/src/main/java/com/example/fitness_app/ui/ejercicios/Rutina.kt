package com.example.fitness_app.ui.ejercicios

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Rutina(
    @SerializedName("nombre") val name:String,
    @SerializedName("image") val image:String,
    @SerializedName("ejercicios") val ejercicios:List<Ejercicio>,
    @SerializedName("calorias") val calorias:Int,
    @SerializedName("duracion") val duracion:Int ) : Serializable