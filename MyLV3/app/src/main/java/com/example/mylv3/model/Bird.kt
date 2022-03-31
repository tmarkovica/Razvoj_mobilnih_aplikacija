package com.example.mylv3.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class Bird(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "title") // Optional!
    val location: String,
    @ColumnInfo(name = "content")
    val content: String,
    @ColumnInfo(name = "priority")
    val priority: BirdPhoto,
    @ColumnInfo(name = "dateAdded")
    val dateAdded: Date
) {

}