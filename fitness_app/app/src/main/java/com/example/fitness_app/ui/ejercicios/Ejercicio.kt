package com.example.fitness_app.ui.ejercicios

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Ejercicio(
    @SerializedName("nombre") val nombre:String,
    @SerializedName("repeticiones") val repeticiones:String,
    @SerializedName("animacion") val anima:String,
    @SerializedName("isCompleted") var isCompleted: Boolean,
    @SerializedName("isSeleted") var isSelected: Boolean) : Serializable