package com.example.twittertwo.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.twittertwo.R
import com.example.twittertwo.view.components.*

@Composable
fun SearchView(
    scrollState: LazyListState,
    scrollUpState: MutableState<Boolean>,
    onBack: () -> Unit
) {

    val isSearching = remember { mutableStateOf(false) }

    if (!isSearching.value){
        Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(visible = !scrollUpState.value) {
                SearchTopBar(
                    scrollUpState = scrollUpState,
                    isSearching = isSearching
                )
            }
            SearchContent(scrollState = scrollState)
        }
    }else{
        Column(
            modifier= Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(visible = !scrollUpState.value) {
                SearchingTopBar(
                    scrollUpState = scrollUpState,
                    isSearching = isSearching
                )
            }
            SearchingContent(scrollState = scrollState)
        }
    }
}

@Composable
private fun SearchTopBar(
    scrollUpState: MutableState<Boolean>,
    isSearching: MutableState<Boolean>
) {
    Column {
        TopBar(
            scrollUpState = scrollUpState,
            startElement = null,
            centerElement = {
                ButtonSearchTopBar(
                    text = stringResource(id = R.string.TopBarButtonSearch)
                ) {isSearching.value = true}
            },
        ) { IconSettingsTopBar() {} }
        CustomDivider()
    }
}

@Composable
private fun SearchContent(
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


@Composable
private fun SearchingTopBar(
    scrollUpState: MutableState<Boolean>,
    isSearching: MutableState<Boolean>
) {

    val searchValue = remember { mutableStateOf("") }

    Column {
        TopBar(
            scrollUpState = scrollUpState,
            startElement = {IconButtonArrowBack { isSearching.value = false }},
            centerElement = {
                Box(
                    modifier = Modifier.fillMaxHeight()
                        .fillMaxWidth(0.8f),
//                    contentAlignment = Alignment.TopStart
                ) {
                    TextFieldTopBar(
                        textFieldValue = searchValue,
                        textLabel = stringResource(id = R.string.TopBarButtonSearch),
                        keyboardType = KeyboardType.Text,
                        keyboardActions = KeyboardActions(
                            onDone = {}
                        ),
                        imeAction = ImeAction.None
                    )
                } },
            endElement = {
                IconButton(onClick = { searchValue.value = "" }) {
                    Icon(imageVector = Icons.Rounded.Close,
                        contentDescription = null,
                        tint = if(searchValue.value.isNotEmpty()) MaterialTheme.colors.primary else Color.Transparent)
                }
            }
        )
        CustomDivider()
    }
}

@Composable
private fun SearchingContent(
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
                        text = "SEARCH ITEM $i",
                        color = MaterialTheme.colors.primary
                    )
                }
                CustomDivider()
            }
        }
    }
}