package com.example.twittertwo.view.components

import android.icu.text.DateTimePatternGenerator.DisplayWidth
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonSearchTopBar(
    modifier: Modifier = Modifier,
    color: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onBackground),
    text: String,
    textColor: Color = MaterialTheme.colors.primary.copy(0.4f),
    fontSize: TextUnit = 16.sp,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(0.7f),
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = color
    ) {
        Text(
            modifier = Modifier.fillMaxWidth()
                .padding(start = 5.dp),
            text = text,
            color = textColor,
            fontSize = fontSize,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.15.sp
        )
    }
}