package com.example.twittertwo.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.twittertwo.R
import com.example.twittertwo.model.NavDrawerOptions
import com.example.twittertwo.navigation.MainDestinations
import kotlinx.coroutines.CoroutineScope

val paddingTop = PaddingValues(start = 15.dp)

@ExperimentalMaterialApi
@Composable
fun NavDrawer(
    closeDrawer: () -> Unit,
    navController: NavHostController,
    mainNavController: NavHostController,
    sheetState: ModalBottomSheetState,
    scaffoldState: ScaffoldState
) {

    val isExpanded = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            TopNavDrawer(
                isExpanded = isExpanded
            )
            CustomDivider()
            BodyNavDrawer(navController = navController)
            BottomNavDrawer(
                mainNavController = mainNavController,
                sheetState = sheetState,
                coroutineScope = coroutineScope,
                scaffoldState = scaffoldState
            )
        }
    }
}

@Composable
fun TopNavDrawer(
    isExpanded: MutableState<Boolean>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingTop)
            .padding(end = 5.dp, top = 5.dp, bottom = 5.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(modifier= Modifier
                .width(80.dp)
                .height(80.dp)
                .clip(shape = CircleShape),
                painter = painterResource(id = R.drawable.avatar_test),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )

            Image(modifier= Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(shape = CircleShape),
                painter = painterResource(id = R.drawable.avatar_test_2),
                contentDescription = "",
                contentScale = ContentScale.FillBounds
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {

            Column(
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.user_name_test),
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = "@${stringResource(id = R.string.user_name_test)}",
                    color = MaterialTheme.colors.primary.copy(alpha = 0.8f),
                )
            }

            IconButton(
                onClick = { isExpanded.value = !isExpanded.value }
            ) {
                if (isExpanded.value){
                    Icon(
                        imageVector = Icons.Rounded.ExpandLess,
                        contentDescription = ""
                    )
                } else{
                    Icon(
                        imageVector = Icons.Rounded.ExpandMore,
                        contentDescription = ""
                    )
                }
            }
        }

        Row(
            modifier= Modifier.padding(top = 15.dp, bottom = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ClickableText(
                style = TextStyle(
                    color = MaterialTheme.colors.primary
                ),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Black
                        )
                    ){
                        append(stringResource(id = R.string.following_number))
                    }
                    append(" Following")
                },
                onClick = {}
            )

            ClickableText(
                style = TextStyle(
                    color = MaterialTheme.colors.primary
                ),
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Black
                        )
                    ){
                        append(stringResource(id = R.string.followers_number))
                    }
                    append(" Followers")
                },
                onClick = {}
            )
        }

    }

}

@Composable
fun BodyNavDrawer(
    navController: NavHostController
) {

    val items = NavDrawerOptions.listOptions.list
    val professionalOption = NavDrawerOptions.Professionals
    val settingsItems = NavDrawerOptions.listSettingsAndHelp.list


    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)
    ){
        items.forEach {
            item {
                DrawerButton(
                    icon = it.icon,
                    label = it.option,
                    action = {
                        navController.navigate(route = it.destination){
                            popUpTo(MainDestinations.HOME_FEED_ROUTE)
                        }
                    }
                )
            }
        }
        item { CustomDivider() }
        item {
            DrawerButton(
                icon = professionalOption.icon,
                label = professionalOption.option,
                action = {
                    navController.navigate(route = professionalOption.destination){
                        popUpTo(MainDestinations.HOME_FEED_ROUTE)
                    }
                }
            )
        }
        item { CustomDivider() }
        settingsItems.forEach {
            item {
                DrawerButton(
                    icon = it.icon,
                    label = it.option,
                    action = {
                        navController.navigate(route = it.destination){
                            popUpTo(MainDestinations.HOME_FEED_ROUTE)
                        }
                    }
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun BottomNavDrawer(
    mainNavController: NavHostController,
    sheetState: ModalBottomSheetState,
    coroutineScope: CoroutineScope,
    scaffoldState: ScaffoldState
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        CustomDivider()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ToggleThemeIconButton(
                modifier = Modifier.fillMaxHeight(),
                sheetState = sheetState,
                coroutine = coroutineScope,
                scaffoldState = scaffoldState
            )
            QrIconButton(
                modifier = Modifier.fillMaxHeight(),
                navController = mainNavController
            )
        }
    }

}

@Composable
private fun DrawerButton(
    icon:ImageVector,
    label: String,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { action() },
        contentAlignment = Alignment.TopStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingTop)
                .padding(vertical = 12.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                imageVector = icon,
                contentDescription = null, // decorative
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
            )
            Spacer(Modifier.width(15.dp))
            Text(
                text = label,
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.h6.fontSize
            )
        }
    }
}



@Composable
private fun CustomDivider() {
    Divider(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.primary.copy(alpha = 0.2f),
        thickness = 0.8.dp
    )
}