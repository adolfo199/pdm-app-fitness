package com.example.fitness_app.ui.recetas

import java.io.Serializable

data class Recetas(val nombre:String,
              val image:Int,
              val temPreparacion:String,
              val porcionces:String,
              val calorias:String,
              val ingredientes:List<String>,
              val instrucciones: List<String>,
              var favorita:Boolean) : Serializable

