package com.example.fitness_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fitness_app.data.dao.UserDao
import com.example.fitness_app.data.dao.UserProfileDao
import com.example.fitness_app.data.entities.UserEntity
import com.example.fitness_app.data.entities.UserProfileEntity

@Database(entities = [
    UserEntity::class,
    UserProfileEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun user():UserDao
    abstract fun userProfile():UserProfileDao


    //patron singleton
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }
    }
}