package com.example.myapplication.data

import com.example.myapplication.model.Person


interface PersonRepository {

    fun save(person: Person)
    fun delete(person: Person)
    fun getTaskById(id: Long): Person?
    fun getAllTasks(): List<Person>
}