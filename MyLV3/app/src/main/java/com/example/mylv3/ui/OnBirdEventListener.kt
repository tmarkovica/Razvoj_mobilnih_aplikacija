package com.example.mylv3.ui

import com.example.mylv3.model.Bird

interface OnBirdEventListener{
    fun onTaskSelected(id: Long?)
    fun onTaskLongPress(task: Bird?): Boolean
}