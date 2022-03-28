package com.example.myapplication.data

import com.example.myapplication.model.Person
import kotlin.random.Random

class InMemoryDb : PersonDao {

    private val people = mutableListOf<Person>()

    init {
        for (i in 1..30) {
            save(
                Person(
                    i.toLong(),
                    "Person_$i",
                    "${Random.nextInt(3)}",
                    mutableListOf("Q1","q2")
            ))
        }
    }

    override fun save(person: Person) {
        people.add(person)
    }

    override fun delete(person: Person) {
        people.remove(person)
    }

    override fun getTaskById(id: Long): Person? {
        return people.firstOrNull { it.id == id }
    }

    override fun getAllTasks(): List<Person> {
        return people
    }


}