package com.example.twittertwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.twittertwo.core.UserPreferences
import com.example.twittertwo.navigation.*
import com.example.twittertwo.ui.theme.TwitterTwoTheme
import com.example.twittertwo.view.components.ThemeAppBottomSheet
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {

            val mainNavController = rememberNavController()
            val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_FEED_ROUTE
            val prefs = UserPreferences(context = applicationContext)
            val isDarkTheme = remember { mutableStateOf( prefs.getTheme()) }
            val isFullDark = remember { mutableStateOf(prefs.getFullDarkTheme()) }

            TwitterTwoTheme(
                darkTheme = isDarkTheme.value,
                fullDark =  isFullDark.value
            ) {

                val systemUiController = rememberSystemUiController()

                systemUiController.setStatusBarColor(
                    color = MaterialTheme.colors.background
                )
                systemUiController.setNavigationBarColor(
                    color = MaterialTheme.colors.background
                )


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    //ThemeAppBottomSheet(bottomSheetScaffoldState = bottomSheetScaffoldState)

                    NavHost(
                        navController = mainNavController,
                        startDestination = MainDestinations.FEED_ROUTE
                    ){
                        addFeed(
                            mainNavController = mainNavController
                        )
                    }
                }
            }
        }
    }
}