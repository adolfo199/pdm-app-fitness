package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.IngredientsEntity

@Dao
interface IngredientsDao {
    @Query("SELECT * FROM ingredients")
    fun getAll(): LiveData<List<IngredientsEntity>>

    @Query("SELECT * FROM ingredients WHERE id = :id" )
    fun get(id:Int): LiveData<IngredientsEntity>

    @Insert
    fun insertAll(vararg ingredient: IngredientsEntity)

    @Update
    fun update(ingredient: IngredientsEntity)

    @Delete
    fun delete(ingredient: IngredientsEntity)
}