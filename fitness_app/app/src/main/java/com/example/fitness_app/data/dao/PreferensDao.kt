package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.PreferensEntity

@Dao
interface PreferensDao {
    @Query("SELECT * FROM preferens")
    fun getAll(): LiveData<List<PreferensEntity>>

    @Query("SELECT * FROM preferens WHERE id = :id" )
    fun get(id:Int): LiveData<PreferensEntity>

    @Insert
    fun insertAll(vararg preferens: PreferensEntity)

    @Update
    fun update(preferens: PreferensEntity)

    @Delete
    fun delete(preferens: PreferensEntity)
}