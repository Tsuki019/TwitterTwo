package com.example.twittertwo.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.twittertwo.navigation.MainDestinations

sealed class BottomNavigationOption(
    val id: String,
    val text: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector,
    val destination: String,
){

    object Home:BottomNavigationOption(
        id = "home",
        text= "Home",
        iconSelected = Icons.Filled.Home,
        iconUnselected = Icons.Rounded.Home,
        destination= MainDestinations.HOME_FEED_ROUTE,
    )

    object Search: BottomNavigationOption(
        id = "search",
        text = "Search",
        iconSelected = Icons.Filled.Search,
        iconUnselected = Icons.Rounded.Search,
        destination = MainDestinations.SEARCH_FEED_ROUTE
    )

    object Notifications: BottomNavigationOption(
        id = "notifications",
        text = "Notifications",
        iconSelected = Icons.Filled.Notifications,
        iconUnselected = Icons.Rounded.Notifications,
        destination = MainDestinations.NOTIFICATIONS_FEED_ROUTE
    )

    object Messages: BottomNavigationOption(
        id = "messages",
        text = "MDs",
        iconSelected = Icons.Filled.Email,
        iconUnselected = Icons.Rounded.Email,
        destination = MainDestinations.MESSAGES_FEED_ROUTE
    )

    object Items{
        val list = listOf(
            Home, Search, Notifications, Messages
        )
    }
}