package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(
    tableName = "exercises",
    foreignKeys = arrayOf(
        ForeignKey(entity = ExercisesTypeEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE)
    )

)
class ExercisesEntity (
          @PrimaryKey(autoGenerate = true)
          val id:Int = 0,
          val name:String,
          val description:String,
          val series:Int,
          val crated:String,
          val idExerciseType:Int
        )