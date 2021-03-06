package com.example.twittertwo.view.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

@Composable
fun IconSwitchTopBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier
            .rotate(180f),
    ) {
        Icon(
            imageVector = Icons.Outlined.AutoAwesome,
            contentDescription = "",
            tint = MaterialTheme.colors.primary
        )
    }
}