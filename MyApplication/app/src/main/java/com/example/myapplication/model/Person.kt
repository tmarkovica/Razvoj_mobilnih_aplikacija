package com.example.myapplication.model

data class Person(
    var id: Long? = null,
    val name: String,
    val birthDate: String,
    val quotes: List<String>
) {

}