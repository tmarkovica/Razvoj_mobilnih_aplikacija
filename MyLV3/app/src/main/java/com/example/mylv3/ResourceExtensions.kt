package com.example.mylv3

import android.content.res.Resources
import android.graphics.Color.blue
import android.graphics.Color.red
import com.example.mylv3.model.BirdPhoto

fun Resources.getPhotoResource(priority: BirdPhoto): Int{
    return when(priority){
        BirdPhoto.Roda -> R.color.red
        BirdPhoto.Papiga -> R.color.green
        else -> R.color.blue
    }
}