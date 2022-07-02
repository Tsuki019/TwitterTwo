package com.example.twittertwo.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.twittertwo.ui.theme.twitterBlue

@Composable
fun TextFieldTopBar(
    modifier: Modifier = Modifier,
    textFieldValue: MutableState<String>,
    textLabel: String,
    maxChar: Int? = null,
    onValueChange : () -> Unit = {},
    capitalization: KeyboardCapitalization = KeyboardCapitalization.None,
    keyboardType: KeyboardType,
    keyboardActions: KeyboardActions,
    imeAction: ImeAction,
    cursorBrush: Color = twitterBlue,
    unFocusedColor : Color = MaterialTheme.colors.primary,
    textColor : Color = MaterialTheme.colors.primary,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None  //Visualizacion de contrasenas
) {

    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        modifier = modifier
            .background(
                color = Color.Transparent
            )
            .fillMaxWidth()
            .fillMaxHeight()
            .focusRequester(focusRequester),
        value = textFieldValue.value,
        onValueChange = {
            textFieldValue.value = it
        },
        singleLine = true,
        cursorBrush = SolidColor(cursorBrush),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colors.onSurface,
            fontSize = 16.sp
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    if (textFieldValue.value.isEmpty())
                        Text(
                            text = textLabel,
                            style = LocalTextStyle.current.copy(
                            color = MaterialTheme.colors.primary.copy(alpha = 0.4f),
                            fontSize = 16.sp
                        )
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        }
    )

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

