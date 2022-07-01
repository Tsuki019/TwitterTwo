package com.example.twittertwo.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AutoAwesome
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.twittertwo.R
import com.example.twittertwo.view.components.CustomDivider

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    scrollUpState: MutableState<Boolean>,
    centerElement: @Composable () -> Unit,
    endElement: @Composable () -> Unit
) {

    val avatarPainter = painterResource(id = R.drawable.avatar_test)
    val position = animateFloatAsState(if (scrollUpState.value) -150f else 0f)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer { translationY = (position.value) }
            .height(56.dp),
        elevation = 8.dp,
        color = MaterialTheme.colors.background
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 5.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    modifier = Modifier
                        .clip(CircleShape)
                        .weight(1f, fill = false)
                        .aspectRatio(avatarPainter.intrinsicSize.width / avatarPainter.intrinsicSize.height),
                    painter = avatarPainter,
                    contentDescription ="Show navigation drawer",
                    contentScale = ContentScale.Fit
                )
                centerElement()
                endElement()
            }
        }
    }
}