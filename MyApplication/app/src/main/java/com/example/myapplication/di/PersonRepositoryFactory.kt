package com.example.myapplication.di

import com.example.myapplication.data.InMemoryDb
import com.example.myapplication.data.PersonDao
import com.example.myapplication.data.PersonRepository
import com.example.myapplication.data.PersonRepositoryImpl

object PersonRepositoryFactory {

    private val personDao: PersonDao = InMemoryDb()
    val peopleRepository: PersonRepository = PersonRepositoryImpl(personDao)
}