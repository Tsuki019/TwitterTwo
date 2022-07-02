package com.example.twittertwo.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twittertwo.view.components.CustomDivider
import com.example.twittertwo.view.components.IconSettingsTopBar

@Composable
fun NotificationsView(
    scrollState: LazyListState,
    scrollUpState: MutableState<Boolean>
) {

    Column(
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = !scrollUpState.value) {
            NotificationsTopBar(scrollUpState = scrollUpState)
        }
        NotificationsContent(scrollState = scrollState)
    }
}

@Composable
private fun NotificationsTopBar(
    scrollUpState: MutableState<Boolean>
) {
    Column {
        TopBar(
            scrollUpState = scrollUpState,
            startElement = null,
            centerElement = {
                Box(
                    modifier = Modifier.fillMaxSize(0.7f),
                    contentAlignment = Alignment.CenterStart
                ){
                    Text(
                        text = "Notifications",
                        fontSize = 20.sp,
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        letterSpacing = 1.sp
                    )
                }
            },
        ) { IconSettingsTopBar() {} }
        CustomDivider()
    }
}

@Composable
private fun NotificationsContent(
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