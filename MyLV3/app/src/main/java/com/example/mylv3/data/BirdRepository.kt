package com.example.mylv3.data

import com.example.mylv3.model.Bird

interface BirdRepository {

    fun save(task: Bird)
    fun delete(task: Bird)
    fun getTaskById(id: Long): Bird?
    fun getAllTasks(): List<Bird>
}