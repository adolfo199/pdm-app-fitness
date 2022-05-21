package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.UserProfileEntity

@Dao
interface UserProfileDao {
    @Query("SELECT * FROM user_Profile")
    fun getAll(): LiveData<List<UserProfileEntity>>

    @Query("SELECT * FROM user_Profile WHERE user_id = :id" )
    fun get(id:Int): LiveData<UserProfileEntity>

    @Insert
    fun insertAll(vararg userProfile: UserProfileEntity)

    @Query("UPDATE user_Profile SET timeExercise = :minute, countExercise = :canEj, kcal = :kcal WHERE user_id=:id ")
    fun update(minute:Int, kcal:Int, canEj:Int, id: Int)

    @Delete
    fun delete(userProfile: UserProfileEntity)
}