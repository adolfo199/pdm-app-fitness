package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.fitness_app.data.entities.UserProfileEntity

@Dao
interface UserProfileDao {
    @Query("SELECT * FROM user_Profile")
    fun getAll(): LiveData<List<UserProfileEntity>>

    @Query("SELECT * FROM user_Profile WHERE id = :id" )
    fun get(id:Int): LiveData<UserProfileEntity>

    @Insert
    fun insertAll(vararg preferens: UserProfileEntity)

    @Update
    fun update(userProfile: UserProfileEntity)

    @Delete
    fun delete(userProfile: UserProfileEntity)
}