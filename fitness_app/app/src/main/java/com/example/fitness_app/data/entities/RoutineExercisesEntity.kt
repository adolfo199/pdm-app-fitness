package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(
    tableName = "routine_exercises",
    foreignKeys = arrayOf(
        ForeignKey(entity = RoutineEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id"),
        onDelete = ForeignKey.CASCADE),

        ForeignKey(entity = ExercisesEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE)
    )

    )
data class RoutineExercisesEntity(
    @PrimaryKey
    val id:Int = 0,
    val id_routine:Int,
    val id_exercise:Int,
    val created_at:String

)