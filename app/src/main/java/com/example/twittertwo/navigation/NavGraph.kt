package com.example.twittertwo.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.twittertwo.view.Feed

object MainDestinations{

    const val FEET_ROUTE = "principal_feet"
    const val HOME_FEED_ROUTE = "home_feed_option"
    const val SEARCH_FEED_ROUTE = "search_feed_option"
    const val NOTIFICATIONS_FEED_ROUTE = "notifications_feed_option"
    const val MESSAGES_FEED_ROUTE = "messages_feed_option"
}


fun NavGraphBuilder.addFeed(
    navController: NavController,
    currentRoute: String
){

    composable(route = MainDestinations.HOME_FEED_ROUTE){
        Feed(
            navController = navController,
            currentRoute = currentRoute
        )
    }
}