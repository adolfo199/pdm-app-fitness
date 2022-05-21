package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "recipes_book",
    foreignKeys = arrayOf(
        ForeignKey(entity = MealsEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE),

        ForeignKey(entity = UserEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE)
    )

)
data class RecipesEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val id_meal:Int,
    val id_user:Int
)