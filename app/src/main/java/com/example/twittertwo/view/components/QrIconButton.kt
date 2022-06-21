package com.example.twittertwo.view.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.material.icons.outlined.QrCode2
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.twittertwo.navigation.MainDestinations

@Composable
fun QrIconButton(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    IconButton(
        onClick = {
            navController.navigate(route = MainDestinations.APP_THEME_OPTIONS){
                popUpTo(route = MainDestinations.HOME_FEED_ROUTE)
            }
        },
        modifier = modifier
    ){
        Icon(
            imageVector = Icons.Outlined.QrCode2,
            contentDescription = "",
            tint = MaterialTheme.colors.primary
        )
    }
}