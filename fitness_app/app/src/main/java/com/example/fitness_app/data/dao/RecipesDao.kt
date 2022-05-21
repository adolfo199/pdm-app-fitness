package com.example.fitness_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.fitness_app.data.entities.RecipesEntity
@Dao
interface RecipesDao {
    @Insert
    fun insertAll(vararg recipe: RecipesEntity)
}