package com.example.twittertwo.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@ExperimentalMaterialApi
fun ThemeAppBottomSheet(
    sheetState: ModalBottomSheetState,
    content: @Composable () -> Unit
) {

    ModalBottomSheetLayout(
        sheetContent ={
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(color = MaterialTheme.colors.background)
            ) {}
        },
        sheetState = sheetState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
    ) {
        content()
    }
}

