package com.example.twittertwo.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.twittertwo.view.*

object MainDestinations{

    const val FEED_ROUTE = "principal_feet"
    const val HOME_FEED_ROUTE = "home_feed_option"
    const val SEARCH_FEED_ROUTE = "search_feed_option"
    const val NOTIFICATIONS_FEED_ROUTE = "notifications_feed_option"
    const val MESSAGES_FEED_ROUTE = "messages_feed_option"
}

/**
 * Main Navigation
 **/

fun NavGraphBuilder.addFeed(){

    composable(route = MainDestinations.FEED_ROUTE){
        Feed()
    }
}

/**
 * Feed Navigation
 **/

fun NavGraphBuilder.addHome(){

    composable(route = MainDestinations.HOME_FEED_ROUTE){
        HomeView()
    }
}

fun NavGraphBuilder.addSearch(){

    composable(route = MainDestinations.SEARCH_FEED_ROUTE){
        SearchView()
    }
}

fun NavGraphBuilder.addNotifications(){

    composable(route = MainDestinations.NOTIFICATIONS_FEED_ROUTE){
        NotificationsView()
    }
}

fun NavGraphBuilder.addMessages(){

    composable(route = MainDestinations.MESSAGES_FEED_ROUTE){
        MessageView()
    }
}