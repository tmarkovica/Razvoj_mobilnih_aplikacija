package com.example.myapplication.data

import com.example.myapplication.model.Person


interface PersonRepository {

    fun save(task: Person)
    fun delete(task: Person)
    fun getTaskById(id: Long): Person?
    fun getAllTasks(): List<Person>
}