package com.example.twittertwo.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.twittertwo.ViewModel.ScrollStateViewModel
import com.example.twittertwo.navigation.*
import com.example.twittertwo.view.components.*

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun Feed(
    mainNavController: NavHostController,
    isDarkTheme: MutableState<Boolean>,
    isLightsOut: MutableState<Boolean>,
    scrollStateVM: ScrollStateViewModel
) {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: MainDestinations.HOME_FEED_ROUTE
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scaffoldState = rememberScaffoldState()

    Surface {
        ThemeAppBottomSheet(
            sheetState = sheetState,
            isDarkTheme = isDarkTheme,
            isLightsOut = isLightsOut
        ) {
            MainFeedContent(
                navController = navController,
                mainNavController = mainNavController,
                sheetState = sheetState,
                currentRoute = currentRoute,
                scaffoldState = scaffoldState,
                scrollStateVM = scrollStateVM
            )
        }
    }
}


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
private fun MainFeedContent(
    navController: NavHostController,
    mainNavController: NavHostController,
    sheetState: ModalBottomSheetState,
    currentRoute: String,
    scaffoldState: ScaffoldState,
    scrollStateVM: ScrollStateViewModel
) {

    val scrollState = rememberLazyListState()
    val scrollUpState = scrollStateVM.scrollUp

    scrollStateVM.updateScrollPosition(scrollState.firstVisibleItemIndex)

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = { NavDrawer(
            navController = navController,
            mainNavController = mainNavController,
            sheetState = sheetState,
            scaffoldState= scaffoldState
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
            addHome(
                scrollState = scrollState,
                scrollUpState = scrollUpState
            )
            addSearch(
                scrollState = scrollState,
                scrollUpState = scrollUpState,
                navHostController = navController
            )
            addNotifications(
                scrollState = scrollState,
                scrollUpState = scrollUpState
            )
            addMessages(
                scrollState = scrollState,
                scrollUpState = scrollUpState
            )
        }
    }
}
