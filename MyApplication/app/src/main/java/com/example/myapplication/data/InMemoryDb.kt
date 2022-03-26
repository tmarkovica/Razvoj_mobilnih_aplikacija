package com.example.myapplication.data

import com.example.myapplication.model.Person
import kotlin.random.Random

class InMemoryDb : TaskDao {

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

    override fun save(task: Person) {
        people.add(task)
    }

    override fun delete(task: Person) {
        people.remove(task)
    }

    override fun getTaskById(id: Long): Person? {
        return people.firstOrNull { it.id == id }
    }

    override fun getAllTasks(): List<Person> {
        return people
    }


}