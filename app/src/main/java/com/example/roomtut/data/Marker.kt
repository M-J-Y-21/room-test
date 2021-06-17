package com.example.roomtut.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "marker_table") data class Marker(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val location: String,
    val colour: String
)