package com.example.fitness_app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.fitness_app.data.entities.RoutineExercisesEntity

@Dao
interface RoutineExercisesDao {

    @Insert
    fun insertAll(vararg routineExercisesEntity: RoutineExercisesEntity)
}