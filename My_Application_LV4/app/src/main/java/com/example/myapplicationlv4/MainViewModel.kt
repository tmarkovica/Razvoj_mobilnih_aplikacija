package com.example.myapplicationlv4

import android.app.Activity
import android.content.Context
import android.provider.Settings.Global.getString
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import com.example.myapplicationlv4.di.sharedPrefers

class MainViewModel(
    private val prefsManager: PreferenceManager
) : ViewModel() {
    private val _team1Score = MutableLiveData<Int>(0)
    val team1Score: LiveData<Int> = _team1Score

    private val _team2Score = MutableLiveData<Int>(0)
    val team2Score: LiveData<Int> = _team2Score

    init {
        val score1: Int = prefsManager.retrieveScore1()
        val score2: Int = prefsManager.retrieveScore2()
        _team1Score.value = score1
        _team2Score.value = score2


    }

    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

//    var count = 0
//        private set

    fun incrementCount() {
        _count.value = (_count.value ?: 0) + 1
    }






    fun team1Scored(score: Int) {
        _team1Score.value = (_team1Score.value ?: 0) + score
    }

    fun team2Scored(score: Int) {
        _team2Score.value = (_team2Score.value ?: 0) + score
    }

    fun resetScore() {
        _team1Score.value = 0
        _team2Score.value = 0
    }

    fun saveScore(): Boolean {
        team1Score.value?.let {
            team2Score.value?.let { it1 ->
                prefsManager.saveScore(
                    it,
                    it1
                )
            }
        }
        return true
    }
}
