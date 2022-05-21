package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.RoutineEntity

@Dao
interface RoutineDao {
    @Query("SELECT * FROM routine")
    fun getAll(): LiveData<List<RoutineEntity>>

    @Query("SELECT * FROM routine WHERE id = :id" )
    fun get(id:Int): LiveData<RoutineEntity>

    @Insert
    fun insertAll(vararg routine: RoutineEntity)

    @Update
    fun update(routine: RoutineEntity)

    @Delete
    fun delete(routine: RoutineEntity)
}