package com.example.mylv3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mylv3.model.Bird

@Database(
    entities = [Bird::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(BirdConverters::class)
abstract class BirdDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {

        private const val databaseName = "notesDb"

        @Volatile
        private var INSTANCE: BirdDatabase? = null

        fun getDatabase(context: Context): BirdDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): BirdDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                BirdDatabase::class.java,
                databaseName
            )
                .allowMainThreadQueries()
                .build()
        }
    }
}