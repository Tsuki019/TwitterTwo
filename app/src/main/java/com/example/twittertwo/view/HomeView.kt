package com.example.twittertwo.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.twittertwo.R
import com.example.twittertwo.view.components.CustomDivider
import com.example.twittertwo.view.components.IconSwitchTopBar
import com.example.twittertwo.view.components.IconTwitterTopBar

@ExperimentalFoundationApi
@Composable
fun HomeView(
    scrollState: LazyListState,
    scrollUpState: MutableState<Boolean>
) {

    Column(
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = !scrollUpState.value) {
            HomeTopBar(scrollUpState = scrollUpState)
        }
        HomeContent(scrollState = scrollState)
    }
}


@Composable
private fun HomeTopBar(
    scrollUpState: MutableState<Boolean>
) {
    Column {
        TopBar(
            scrollUpState = scrollUpState,
            startElement = null,
            centerElement = {
                IconTwitterTopBar(avatarPainter = painterResource(id = R.drawable.twitter_icon))
            },
        ) { IconSwitchTopBar {} }
        CustomDivider()
    }
}

@Composable
private fun HomeContent(
    scrollState: LazyListState
) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        state = scrollState,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        for (i in 0..50){
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    backgroundColor = MaterialTheme.colors.background
                ) {
                    Text(
                        text = "ITEM $i",
                        color = MaterialTheme.colors.primary
                    )
                }
                CustomDivider()
            }
        }
    }
}