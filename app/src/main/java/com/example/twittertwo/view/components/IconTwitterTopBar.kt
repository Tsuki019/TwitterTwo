package com.example.twittertwo.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.twittertwo.R


@Composable
fun IconTwitterTopBar(
    modifier: Modifier = Modifier,
    avatarPainter: Painter
) {
    Image(
        modifier = modifier
            .padding(3.dp)
//            .weight(1f, fill = false)
            .aspectRatio(avatarPainter.intrinsicSize.width / avatarPainter.intrinsicSize.height),
        painter = painterResource(id = R.drawable.twitter_icon),
        contentDescription = "",
        contentScale = ContentScale.Fit
    )
}