package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.ExercisesEntity

@Dao
interface ExercisesDao {
    @Query("SELECT * FROM exercises")
    fun getAll(): LiveData<List<ExercisesEntity>>

    @Query("SELECT * FROM exercises WHERE id = :id" )
    fun get(id:Int): LiveData<ExercisesEntity>

    @Insert
    fun insertAll(vararg exercise: ExercisesEntity)

    @Update
    fun update(exercise: ExercisesEntity)

    @Delete
    fun delete(exercise: ExercisesEntity)
}