package com.example.twittertwo.navigation

import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.twittertwo.view.*
import com.example.twittertwo.view.components.ThemeAppBottomSheet

object MainDestinations{

    const val FEED_ROUTE = "principal_feet"
    const val HOME_FEED_ROUTE = "home_feed_option"
    const val SEARCH_FEED_ROUTE = "search_feed_option"
    const val NOTIFICATIONS_FEED_ROUTE = "notifications_feed_option"
    const val MESSAGES_FEED_ROUTE = "messages_feed_option"
    const val APP_THEME_OPTIONS = "app_theme_options"
}

/**
 * Main Navigation
 **/

@ExperimentalMaterialApi
fun NavGraphBuilder.addFeed(
    mainNavController: NavHostController,
){

    composable(route = MainDestinations.FEED_ROUTE){
        Feed(
            mainNavController = mainNavController
        )
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

/**
 * Others Routes
 **/

//@ExperimentalMaterialApi
//fun NavGraphBuilder.addAppTheme(){
//    composable(route= MainDestinations.APP_THEME_OPTIONS){
//        ThemeAppBottomSheet()
//    }
//}