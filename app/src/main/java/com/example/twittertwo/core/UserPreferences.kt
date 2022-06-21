package com.example.twittertwo.core

import android.content.Context

class UserPreferences(val context: Context) {

    val DB_NAME = "DB_Preferences"
    val DB_APPTHEME = "DB_AppTheme"
    val DB_FULLDARKTHEME = "DB_FullDarkTheme"

    val prefs = context.getSharedPreferences(DB_NAME, 0)

    fun saveTheme(darkTheme : Boolean){
        prefs.edit().putBoolean(DB_APPTHEME, darkTheme).apply()
    }

    fun getTheme(): Boolean{
        return prefs.getBoolean(DB_APPTHEME, false)
    }

    fun saveFullDarkTheme(darkTheme : Boolean){
        prefs.edit().putBoolean(DB_FULLDARKTHEME, darkTheme).apply()
    }

    fun getFullDarkTheme(): Boolean{
        return prefs.getBoolean(DB_FULLDARKTHEME, false)
    }
}

