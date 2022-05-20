package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.ExercisesTypeEntity

@Dao
interface ExerciseTypeDao {
    @Query("SELECT * FROM exercises_type")
    fun getAll(): LiveData<List<ExercisesTypeEntity>>

    @Query("SELECT * FROM exercises_type WHERE id = :id" )
    fun get(id:Int): LiveData<ExercisesTypeEntity>

    @Insert
    fun insertAll(vararg exerciseType: ExercisesTypeEntity)

    @Update
    fun update(exerciseType: ExercisesTypeEntity)

    @Delete
    fun delete(exerciseType: ExercisesTypeEntity)
}