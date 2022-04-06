package com.example.myapplicationlv4

import android.content.Context

class PreferenceManager(val context: Context) {
    companion object {
        const val PREFS_FILE = "MyPreferences"

        const val TEAM1 = "Team1"
        const val TEAM2 = "Team2"
    }

    fun saveScore(score1: Int, score2: Int) {
        val sharedPreferences = context.applicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putInt(TEAM1, score1)
        editor.putInt(TEAM2, score2)
        editor.apply()
    }

    fun retrieveScore1(): Int {
        val sharedPreferences = context.applicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )

        return sharedPreferences.getInt(TEAM1, 0)
    }

    fun retrieveScore2(): Int {
        val sharedPreferences = context.applicationContext.getSharedPreferences(
            PREFS_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getInt(TEAM2, 0)
    }
}