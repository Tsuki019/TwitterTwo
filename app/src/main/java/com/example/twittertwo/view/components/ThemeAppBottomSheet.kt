package com.example.twittertwo.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HorizontalRule
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.twittertwo.core.UserPreferences

@Composable
@ExperimentalMaterialApi
fun ThemeAppBottomSheet(
    sheetState: ModalBottomSheetState,
    isDarkTheme: MutableState<Boolean>,
    isLightsOut: MutableState<Boolean>,
    content: @Composable () -> Unit
) {

    ModalBottomSheetLayout(
        sheetContent ={
            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            ) {
                BottomSheetContent(
                    isDarkTheme = isDarkTheme,
                    isLightsOut = isLightsOut
                )
            }
        },
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetBackgroundColor = MaterialTheme.colors.background
    ) {
        content()
    }
}

@Composable
fun BottomSheetContent(
    isDarkTheme: MutableState<Boolean>,
    isLightsOut: MutableState<Boolean>
) {

    val prefs = UserPreferences(context = LocalContext.current.applicationContext)
    val theme = remember { mutableStateOf(prefs.getThemeText()!!) }
    val darkTheme = remember { mutableStateOf(prefs.getFullDarkThemeText()!!) }
    val titlePadding = 16.dp
    val optionsPadding = 20.dp

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Icon(
                modifier = Modifier.width(30.dp),
                imageVector = Icons.Outlined.HorizontalRule,
                contentDescription = "",
                tint = MaterialTheme.colors.primary.copy(0.2f)
            )
        }
        Divider(
            color = Color.Transparent,
            thickness = 15.dp
        )
        Text(
            modifier= Modifier.padding(start = titlePadding),
            text = "Dark mode",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
        CustomDivider(
            modifier = Modifier.padding(vertical = 10.dp)
        )
        OptionsDarkTheme(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = optionsPadding),
            optionsList = listOf("Off", "On", "Use device settings"),
            option = theme,
            prefs = prefs,
            isDarkTheme = isDarkTheme,
            isLightsOut = isLightsOut
        )
        CustomDivider(
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
            modifier= Modifier.padding(start = titlePadding),
            text = "Dark theme",
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.h6.fontSize,
            fontWeight = FontWeight.Bold
        )
        OptionsDarkTheme(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = optionsPadding),
            optionsList = listOf("Dim", "Lights out"),
            option = darkTheme,
            prefs = prefs,
            isDarkTheme = isDarkTheme,
            isLightsOut = isLightsOut
        )
    }
}

@Composable
fun OptionsDarkTheme(
    modifier: Modifier = Modifier,
    optionsList: List<String>,
    option: MutableState<String>,
    prefs: UserPreferences,
    isDarkTheme: MutableState<Boolean>,
    isLightsOut: MutableState<Boolean>
) {
    optionsList.forEach {
        val changeTheme = remember { mutableStateOf(false) }

        Row(
            modifier= modifier,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = it,
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h6.fontSize,
            )
            RadioButton(
                selected = it == option.value,
                onClick = {
                    option.value = it
                    changeTheme.value = true },
                colors = RadioButtonDefaults.colors(Color.Cyan)
            )
        }

        if (changeTheme.value){
            prefs.SetTheme(theme = it)
            isDarkTheme.value = prefs.getTheme()
            isLightsOut.value = prefs.getFullDarkTheme()
            changeTheme.value = false
        }
    }



}

