package com.example.mylv3.model

sealed class BirdPhoto{
    object Roda : BirdPhoto() {
        override fun toString(): String = "HIGH"
    }
    object Papiga : BirdPhoto() {
        override fun toString(): String = "MEDIUM"
    }
    object Slavuj : BirdPhoto(){
        override fun toString(): String = "LOW"
    }
}