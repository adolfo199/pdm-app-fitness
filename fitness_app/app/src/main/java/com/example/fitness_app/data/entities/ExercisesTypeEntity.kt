package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercises_type")
class ExercisesTypeEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val name:String,
    val description:String
)
