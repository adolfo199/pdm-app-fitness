package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_Profile")
data class UserProfileEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val height:Int,
    val weight:Int,
    val imc:Float,
    val timeExercise:Int = 0,
    val countExercise:Int = 0,
    val kcal:Int = 0,
)
