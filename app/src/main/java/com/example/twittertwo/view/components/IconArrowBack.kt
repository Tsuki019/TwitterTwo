package com.example.twittertwo.view.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun IconButtonArrowBack(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
    onBack: () -> Unit
) {
    IconButton(
        onClick = { onBack() },
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = null,
            tint = color
        )
    }
}