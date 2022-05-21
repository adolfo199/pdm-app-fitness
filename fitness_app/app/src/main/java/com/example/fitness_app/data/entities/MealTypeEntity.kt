package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "meal_type"
)
class MealTypeEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val description:String,
    val image:Int
)
