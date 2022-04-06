package com.example.myapplicationlv4.di

import android.app.Application
import com.example.myapplicationlv4.App
import com.example.myapplicationlv4.MainViewModel
import com.example.myapplicationlv4.PreferenceManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sharedPrefers = module {
    single<PreferenceManager>() { PreferenceManager(get()) }
}

val viewModelModule = module {
    viewModel<MainViewModel>() { MainViewModel(get<PreferenceManager>()) }
}

