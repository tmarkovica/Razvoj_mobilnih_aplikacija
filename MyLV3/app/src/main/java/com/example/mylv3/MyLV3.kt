package com.example.mylv3

import android.app.Application

class MyLV3: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        lateinit var application: MyLV3
    }
}