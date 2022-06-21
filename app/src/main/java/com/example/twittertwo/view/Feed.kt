package com.example.twittertwo.view

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.twittertwo.navigation.*
import com.example.twittertwo.view.components.BottomNavigation
import com.example.twittertwo.view.components.NavDrawer
import com.example.twittertwo.view.components.ThemeAppBottomSheet

@ExperimentalMaterialApi
@Composable
fun Feed(
    mainNavController: NavHostController
) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_FEED_ROUTE
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scaffoldState = rememberScaffoldState()

    Surface() {
        ThemeAppBottomSheet(
            sheetState = sheetState,
        ) {
            MainFeedContent(
                navController = navController,
                mainNavController = mainNavController,
                sheetState = sheetState,
                currentRoute = currentRoute,
                scaffoldState = scaffoldState
            )
        }
    }
}


@ExperimentalMaterialApi
@Composable
private fun MainFeedContent(
    navController: NavHostController,
    mainNavController: NavHostController,
    sheetState: ModalBottomSheetState,
    currentRoute: String,
    scaffoldState: ScaffoldState
) {
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { NavDrawer(
            closeDrawer = {},
            navController = navController,
            mainNavController = mainNavController,
            sheetState = sheetState,
            scaffoldState= scaffoldState,
        )},
        drawerShape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
        bottomBar = {
            BottomNavigation(
                navController = navController,
                currentRoute = currentRoute
            ) },
        backgroundColor = MaterialTheme.colors.background,

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
