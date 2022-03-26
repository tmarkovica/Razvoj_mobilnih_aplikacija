package com.example.myapplication.data

import com.example.myapplication.model.Person

class PersonRepositoryImpl(val taskDao: TaskDao) : PersonRepository {
    override fun save(task: Person) = taskDao.save(task)
    override fun delete(task: Person) = taskDao.delete(task)
    override fun getTaskById(id: Long): Person? = taskDao.getTaskById(id)
    override fun getAllTasks(): List<Person> = taskDao.getAllTasks()
}