package com.example.mylv3.data

import androidx.room.*
import com.example.mylv3.model.Bird

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(task: Bird)

    @Delete
    fun delete(task: Bird)

    @Query("SELECT * FROM tasks WHERE id =:id")
    fun getTaskById(id: Long): Bird?

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<Bird>
}
