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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.twittertwo.view.components.ButtonSearchTopBar
import com.example.twittertwo.view.components.CustomDivider
import com.example.twittertwo.view.components.IconSettingsTopBar
import com.example.twittertwo.R

@Composable
fun MessageView(
    scrollState: LazyListState,
    scrollUpState: MutableState<Boolean>
) {

    Column(
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(visible = !scrollUpState.value) {
            MessageTopBar(scrollUpState = scrollUpState)
        }
        MessageContent(scrollState = scrollState)
    }
}

@Composable
private fun MessageTopBar(
    scrollUpState: MutableState<Boolean>
) {

    Column {
        TopBar(
            scrollUpState = scrollUpState,
            startElement = null,
            centerElement = {
                ButtonSearchTopBar(
                    text = stringResource(id = R.string.TopBarButtonMessages)
                ){}
            },
        ) { IconSettingsTopBar() {} }
        CustomDivider()
    }
}

@Composable
private fun MessageContent(
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