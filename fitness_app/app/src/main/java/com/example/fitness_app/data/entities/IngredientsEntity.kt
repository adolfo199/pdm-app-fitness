package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ingredients")
class IngredientsEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String
        )