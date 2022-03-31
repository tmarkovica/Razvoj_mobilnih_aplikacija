package com.example.mylv3.data

import com.example.mylv3.model.Bird

class BirdRepositoryImpl(val taskDao: TaskDao) : BirdRepository {
    override fun save(task: Bird) = taskDao.save(task)
    override fun delete(task: Bird) = taskDao.delete(task)
    override fun getTaskById(id: Long): Bird? = taskDao.getTaskById(id)
    override fun getAllTasks(): List<Bird> = taskDao.getAllTasks()
}