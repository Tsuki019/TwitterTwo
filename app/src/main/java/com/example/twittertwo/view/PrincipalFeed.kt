package com.example.twittertwo.view

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.twittertwo.navigation.MainDestinations
import com.example.twittertwo.view.components.BottomNavigation

@Composable
fun Feed(
    navController: NavController,
    currentRoute: String
) {

    Scaffold(
        bottomBar = {BottomNavigation(
            navController = navController,
            currentRoute = currentRoute
        )},
        backgroundColor = MaterialTheme.colors.background
    ) {

    }
}

