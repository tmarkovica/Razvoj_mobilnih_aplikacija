package com.example.mylv3.di

import com.example.mylv3.MyLV3
import com.example.mylv3.data.BirdDatabase
import com.example.mylv3.data.BirdRepository
import com.example.mylv3.data.BirdRepositoryImpl

object BirdRepositoryFactory {

    val roomDb = BirdDatabase.getDatabase(MyLV3.application)
    val taskRepository: BirdRepository = BirdRepositoryImpl(roomDb.getTaskDao())
}