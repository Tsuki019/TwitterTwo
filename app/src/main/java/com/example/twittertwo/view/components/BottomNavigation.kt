package com.example.twittertwo.view.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.twittertwo.model.BottomNavigationOption
import com.example.twittertwo.navigation.MainDestinations
import com.example.twittertwo.ui.theme.TwitterTwoTheme

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController,
    currentRoute: String
) {

    val bottomNavOptions = BottomNavigationOption.Items.list

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        bottomNavOptions.forEach {
            BottomNavigationItem(
                item = it,
                isSelected = it.destination == currentRoute
            ) {
                navController.navigate(it.destination){
                    if (it.destination == MainDestinations.HOME_FEED_ROUTE){
                        popUpTo(0)
                    }else{
                        popUpTo(MainDestinations.HOME_FEED_ROUTE)
                    }
                }
            }
        }
    }
}

@Composable
private fun BottomNavigationItem(
    item: BottomNavigationOption,
    isSelected: Boolean,
    onClick: () -> Unit
) {

    //*TODO Pensar en el diseno del bottomBarNavidation*
    val background = if (isSelected) MaterialTheme.colors.background
    else MaterialTheme.colors.background.copy(alpha = 0.7f)
    val contentColor = if (isSelected) MaterialTheme.colors.primary
    else MaterialTheme.colors.primary.copy(alpha = 0.7f)


    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .border(color = contentColor, width = 1.dp, shape = CircleShape)
                .clip(CircleShape)
                .background(background)
                .clickable(onClick = onClick))
        {
            Row(
                modifier = Modifier
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Icon(
                    imageVector = if (isSelected) item.iconSelected else item.iconUnselected,
                    contentDescription = null,
                    tint = contentColor
                )

                AnimatedVisibility(visible = isSelected) {
                    Text(text = item.text, fontFamily= FontFamily.SansSerif,
                        color = contentColor)
                }
            }
        }
    }
}


@Preview
@Composable
fun BottomNavigationItemSelectedTest() {

    TwitterTwoTheme {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .background(color = MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ){
            Row (horizontalArrangement = Arrangement.spacedBy(5.dp)){
                BottomNavigationItem(
                    item = BottomNavigationOption.Home,
                    isSelected = true,
                    onClick = {}
                )
                BottomNavigationItem(
                    item = BottomNavigationOption.Search,
                    isSelected = false,
                    onClick = {}
                )

            }
        }

    }

}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun BottomNavigationItemUnselectedTest2() {

    TwitterTwoTheme {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(100.dp)
                .background(color = MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ){
            Row (horizontalArrangement = Arrangement.spacedBy(5.dp)){
                BottomNavigationItem(
                    item = BottomNavigationOption.Home,
                    isSelected = true,
                    onClick = {}
                )
                BottomNavigationItem(
                    item = BottomNavigationOption.Search,
                    isSelected = false,
                    onClick = {}
                )
            }
        }

    }

}