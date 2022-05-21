package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.ExercisesTypeEntity
import com.example.fitness_app.data.entities.MealsEntity

@Dao
interface MealsDao {
    @Query("SELECT * FROM meals")
    fun getAll(): LiveData<List<MealsEntity>>

    @Query("SELECT * FROM meals WHERE id = :id" )
    fun get(id:Int): LiveData<MealsEntity>

    @Insert
    fun insertAll(vararg meal: MealsEntity)

    @Update
    fun update(meal: MealsEntity)

    @Delete
    fun delete(meal: MealsEntity)
}