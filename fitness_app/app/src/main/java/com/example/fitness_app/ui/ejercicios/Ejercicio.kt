package com.example.fitness_app.ui.ejercicios

import java.io.Serializable

class Ejercicio(val nombre:String,
                val repeticiones:String,
                val anima:Int,
                var isCompleted: Boolean = false,
                var isSelected: Boolean = false) : Serializable