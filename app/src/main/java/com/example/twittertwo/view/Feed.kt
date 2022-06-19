package com.example.twittertwo.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.twittertwo.navigation.*
import com.example.twittertwo.view.components.BottomNavigation
import com.example.twittertwo.view.components.NavDrawer

@Composable
fun Feed(

) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_FEED_ROUTE

    Scaffold(
        drawerContent = { NavDrawer(
            closeDrawer = {},
            navController = navController
        )},
        drawerShape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
        bottomBar = {
            BottomNavigation(
                navController = navController,
                currentRoute = currentRoute
            )},
        backgroundColor = MaterialTheme.colors.background
    ) {
        NavHost(
            navController = navController,
            startDestination = MainDestinations.HOME_FEED_ROUTE
        ){
            addHome()
            addSearch()
            addNotifications()
            addMessages()
        }
    }
}

