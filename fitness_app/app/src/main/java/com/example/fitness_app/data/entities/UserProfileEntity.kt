package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "user_Profile")
data class UserProfileEntity(
    val height:Int,
    val weight:Int,
    val imc:Float,
    val timeExercise:Int = 0,
    val countExercise:Int = 0,
    val kcal:Int = 0,
    val user_id:Int,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0
)