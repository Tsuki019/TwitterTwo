package com.example.twittertwo.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HelpCenter
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavDrawerOptions(
    val id: String,
    val option: String,
    val icon: ImageVector,
    val destination : String
){
    object Profile: NavDrawerOptions(
        id = "profile",
        option = "Profile",
        icon = Icons.Rounded.Person,
        destination = ""
    )

    object List: NavDrawerOptions(
        id = "list",
        option = "List",
        icon = Icons.Rounded.ListAlt,
        destination = ""
    )

    object Topics: NavDrawerOptions(
        id = "topics",
        option = "Topics",
        icon = Icons.Rounded.StickyNote2,
        destination = ""
    )

    object BookMarks: NavDrawerOptions(
        id = "bookMarks",
        option = "BookMarks",
        icon = Icons.Rounded.BookmarkBorder,
        destination = ""
    )

    object Moments: NavDrawerOptions(
        id = "moments",
        option = "Moments",
        icon = Icons.Rounded.Bolt,
        destination = ""
    )

    object Monetization: NavDrawerOptions(
        id = "monetization",
        option = "Monetization",
        icon = Icons.Rounded.LocalAtm,
        destination = ""
    )

    object Professionals: NavDrawerOptions(
        id = "professionals",
        option = "Twitter for Professionals",
        icon = Icons.Rounded.Engineering,
        destination = ""
    )

    object Settings: NavDrawerOptions(
        id = "settings",
        option = "Settings and privacy",
        icon = Icons.Rounded.Settings,
        destination = ""
    )

    object Help: NavDrawerOptions(
        id = "help",
        option = "Help Center",
        icon = Icons.Outlined.HelpCenter,
        destination = ""
    )

    object listOptions {
        val list = listOf(Profile,List, Topics, BookMarks, Moments, Monetization)
    }

    object listSettingsAndHelp {
        val list = listOf(Settings, Help)
    }
}
