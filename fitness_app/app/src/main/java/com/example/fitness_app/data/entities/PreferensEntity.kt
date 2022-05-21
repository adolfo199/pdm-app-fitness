package com.example.fitness_app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.sql.Time

@Entity(
    tableName = "preferens",
    foreignKeys = arrayOf(
        ForeignKey(entity = UserEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("id"),
            onDelete = ForeignKey.CASCADE),

    )

)
class PreferensEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val darkMode:Boolean = false,
    val activeNotification:Boolean = false,
    val sheduleHourNotification:String,
    val idUser:Int

)
