package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.MealTypeEntity

@Dao
interface MealTypeDao {
    @Query("SELECT * FROM meal_type")
    fun getAll(): LiveData<List<MealTypeEntity>>

    @Query("SELECT * FROM meal_type WHERE id = :id" )
    fun get(id:Int): LiveData<MealTypeEntity>

    @Insert
    fun insertAll(vararg mealType: MealTypeEntity)

    @Update
    fun update(mealType: MealTypeEntity)

    @Delete
    fun delete(mealType: MealTypeEntity)
}