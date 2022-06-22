package com.example.twittertwo.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lightbulb
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.twittertwo.core.UserPreferences
import com.example.twittertwo.navigation.MainDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ToggleThemeIconButton(
    modifier: Modifier = Modifier,
    sheetState: ModalBottomSheetState,
    coroutine: CoroutineScope,
    scaffoldState: ScaffoldState
) {

    IconButton(
        onClick = {
            coroutine.launch {
                if (!sheetState.isVisible){
                    sheetState.show()
                }else{
                    sheetState.hide()
                }
            }
            coroutine.launch { scaffoldState.drawerState.close() }
        },
        modifier = modifier
    ){
        Icon(
            imageVector = Icons.Outlined.Lightbulb,
            contentDescription = "",
            tint = MaterialTheme.colors.primary
        )
    }
}