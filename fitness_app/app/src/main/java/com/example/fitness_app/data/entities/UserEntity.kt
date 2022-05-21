package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class UserEntity(
    val email:String,
    val password:String,
    val name:String,
    val surname:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0

        )