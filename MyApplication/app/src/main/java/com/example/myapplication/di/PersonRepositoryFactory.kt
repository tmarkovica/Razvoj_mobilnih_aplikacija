package com.example.myapplication.di

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.InMemoryDb
import com.example.myapplication.data.PersonRepository
import com.example.myapplication.data.PersonRepositoryImpl
import com.example.myapplication.data.TaskDao
import com.example.myapplication.ui.person_list.PersonAdapter

object PersonRepositoryFactory {

    private val taskDao: TaskDao = InMemoryDb()
    val taskRepository: PersonRepository = PersonRepositoryImpl(taskDao)
}