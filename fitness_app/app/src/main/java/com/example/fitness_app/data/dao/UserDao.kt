package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fitness_app.data.entities.ExercisesEntity
import com.example.fitness_app.data.entities.RoutineEntity
import com.example.fitness_app.data.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
   fun LoginUser(email: String, password: String):LiveData<UserEntity>

    @Query("SELECT id FROM user WHERE email = :email AND password = :password")
    fun getId(email: String, password: String):Int

    @Query("SELECT * FROM user WHERE id = :id" )
    fun get(id:Int): LiveData<UserEntity>

    @Insert
    fun insertAll(vararg user: UserEntity)

    @Query("SELECT * FROM user")
    fun getAll(): LiveData<List<UserEntity>>

}