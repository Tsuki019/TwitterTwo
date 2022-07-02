package com.example.twittertwo.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.twittertwo.ViewModel.ScrollStateViewModel
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

@ExperimentalFoundationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.addFeed(
    mainNavController: NavHostController,
    isDarkTheme: MutableState<Boolean>,
    isLightsOut: MutableState<Boolean>,
    scrollStateVM : ScrollStateViewModel
){

    composable(route = MainDestinations.FEED_ROUTE){
        Feed(
            mainNavController = mainNavController,
            isDarkTheme= isDarkTheme,
            isLightsOut= isLightsOut,
            scrollStateVM = scrollStateVM
        )
    }
}

/**
 * Feed Navigation
 **/

@ExperimentalFoundationApi
fun NavGraphBuilder.addHome(
    scrollState : LazyListState,
    scrollUpState: MutableState<Boolean>
){

    composable(route = MainDestinations.HOME_FEED_ROUTE){
        HomeView(
            scrollState = scrollState,
            scrollUpState = scrollUpState
        )
    }
}

fun NavGraphBuilder.addSearch(
    scrollState : LazyListState,
    scrollUpState: MutableState<Boolean>,
    navHostController: NavHostController
){

    composable(route = MainDestinations.SEARCH_FEED_ROUTE){
        SearchView(
            scrollState = scrollState,
            scrollUpState = scrollUpState,
            onBack = {navHostController.popBackStack()}
        )
    }
}

fun NavGraphBuilder.addNotifications(
    scrollState : LazyListState,
    scrollUpState: MutableState<Boolean>
){

    composable(route = MainDestinations.NOTIFICATIONS_FEED_ROUTE){
        NotificationsView(
            scrollState = scrollState,
            scrollUpState = scrollUpState
        )
    }
}

fun NavGraphBuilder.addMessages(
    scrollState : LazyListState,
    scrollUpState: MutableState<Boolean>
){

    composable(route = MainDestinations.MESSAGES_FEED_ROUTE){
        MessageView(
            scrollState = scrollState,
            scrollUpState = scrollUpState
        )
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