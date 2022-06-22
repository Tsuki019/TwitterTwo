package com.example.twittertwo.core

import android.content.Context
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

class UserPreferences(val context: Context) {

    val DB_NAME = "DB_Preferences"
    val DB_APPTHEME = "DB_AppTheme"
    val DB_FULLDARKTHEME = "DB_FullDarkTheme"
    val DB_DARKMODE = "DB_DarkMode"
    val DB_LIGHTSOUT = "DB_LightsOut"

    val prefs = context.getSharedPreferences(DB_NAME, 0)

    fun saveTheme(darkTheme : Boolean){
        prefs.edit().putBoolean(DB_APPTHEME, darkTheme).apply()
    }

    fun getTheme(): Boolean{
        return prefs.getBoolean(DB_APPTHEME, true)
    }

    fun saveFullDarkTheme(darkTheme : Boolean){
        prefs.edit().putBoolean(DB_FULLDARKTHEME, darkTheme).apply()
    }

    fun getFullDarkTheme(): Boolean{
        return prefs.getBoolean(DB_FULLDARKTHEME, false)
    }

    fun saveThemeText(darkTheme : String){
        prefs.edit().putString(DB_DARKMODE, darkTheme).apply()
    }

    fun getThemeText(): String?{
        return prefs.getString(DB_DARKMODE, "On")
    }

    fun saveFullDarkThemeText(darkTheme : String){
        prefs.edit().putString(DB_LIGHTSOUT, darkTheme).apply()
    }

    fun getFullDarkThemeText(): String?{
        return prefs.getString(DB_LIGHTSOUT, "Dim")
    }

    @Composable
    fun SetTheme(
        theme: String
    ){
        when(theme){
            "Dim" -> {saveFullDarkTheme(false)
                        saveFullDarkThemeText("Dim")}
            "Lights out" -> {saveFullDarkTheme(true)
                        saveFullDarkThemeText("Lights out")}
            "On" -> {saveTheme(true)
                        saveThemeText("On")}
            "Off" -> {saveTheme(false)
                        saveThemeText("Off")}
            "Use device settings" -> {saveTheme(isSystemInDarkTheme())
                        saveThemeText("Use device settings")}
        }
    }
}

