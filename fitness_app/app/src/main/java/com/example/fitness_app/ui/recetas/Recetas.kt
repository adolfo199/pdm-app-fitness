package com.example.fitness_app.ui.recetas

import java.io.Serializable

data class Recetas(val nombre:String,
              val image:String,
              val temPreparacion:String,
              val porciones:String,
              val calorias:String,
              val ingredientes:List<String>,
              val instrucciones: List<String>,
              val categoria:String) : Serializable

