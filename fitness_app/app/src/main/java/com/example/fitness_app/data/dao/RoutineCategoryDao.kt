package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.RoutineCategoryEntity

@Dao
interface RoutineCategoryDao {
    @Query("SELECT * FROM routine_category")
    fun getAll(): LiveData<List<RoutineCategoryEntity>>

    @Query("SELECT * FROM routine_category WHERE id = :id" )
    fun get(id:Int): LiveData<RoutineCategoryEntity>

    @Insert
    fun insertAll(vararg routineCategory: RoutineCategoryEntity)

    @Update
    fun update(routineCategory: RoutineCategoryEntity)

    @Delete
    fun delete(routineCategory: RoutineCategoryEntity)
}