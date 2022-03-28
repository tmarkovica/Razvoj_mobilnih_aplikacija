package com.example.myapplication.data

import com.example.myapplication.model.Person

class PersonRepositoryImpl(val taskDao: PersonDao) : PersonRepository {
    override fun save(person: Person) = taskDao.save(person)
    override fun delete(person: Person) = taskDao.delete(person)
    override fun getTaskById(id: Long): Person? = taskDao.getTaskById(id)
    override fun getAllTasks(): List<Person> = taskDao.getAllTasks()
}