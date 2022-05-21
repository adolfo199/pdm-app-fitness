package com.example.fitness_app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fitness_app.data.dao.*
import com.example.fitness_app.data.entities.*

@Database(entities = [
    UserEntity::class,
    UserProfileEntity::class,
    ExercisesTypeEntity::class,
    MealTypeEntity::class,
    ExercisesEntity::class,
    MealsEntity::class,
    PreferensEntity::class,
    RecipesEntity::class,
    RoutineCategoryEntity::class,
    RoutineEntity::class,
    RoutineExercisesEntity::class,
    IngredientsEntity::class,

                     ], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exercises(): ExercisesDao
    abstract fun exercisesType(): ExerciseTypeDao
    abstract fun ingredients(): IngredientsDao
    abstract fun meals():MealsDao
    abstract fun mealsType():MealTypeDao
    abstract fun preferens(): PreferensDao
    abstract fun recipes():RecipesDao
    abstract fun routineCategory():RoutineCategoryDao
    abstract fun routine():RoutineDao
    abstract fun routineExercises():RoutineExercisesDao
    abstract fun user():UserDao
    abstract fun userProfile():UserProfileDao


    //patron singledon
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