package com.example.myapplicationlv4

import android.app.Application
import com.example.myapplicationlv4.di.sharedPrefers
import com.example.myapplicationlv4.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(viewModelModule, sharedPrefers)

        }
        application = this
    }

    companion object{
        lateinit var application: Application
    }
}