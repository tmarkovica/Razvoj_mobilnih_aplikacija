package com.example.mylv3.data

import androidx.room.TypeConverter
import com.example.mylv3.model.BirdPhoto
import java.util.*

class BirdConverters {

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toString(priority: BirdPhoto): String{
        return priority.toString()
    }

    @TypeConverter
    fun fromString(priority: String): BirdPhoto{
        return when(priority){
            BirdPhoto.Roda.toString() -> BirdPhoto.Roda
            BirdPhoto.Papiga.toString() -> BirdPhoto.Papiga
            BirdPhoto.Slavuj.toString() -> BirdPhoto.Slavuj
            else -> BirdPhoto.Slavuj
        }
    }
}