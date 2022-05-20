package com.example.fitness_app.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fitness_app.data.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun getLoginUser(email: String, password: String): Boolean

    @Query("SELECT * FROM user WHERE id = :id" )
    fun get(id:Int): LiveData<UserEntity>

    @Insert
    fun insertAll(vararg user: UserEntity)

}