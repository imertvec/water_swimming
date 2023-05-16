package ru.vagavagus.waterswimming.presentation.common.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ru.vagavagus.waterswimming.ui.theme.Blue

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val items = listOf(
        NavigationItem.Championships,
        NavigationItem.Medals
    )

    BottomNavigation(
        backgroundColor = Blue,
        contentColor = Color.Black
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(40.dp).padding(5.dp),
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title
                    ) },
                label = { /*Text(text = item.title)*/ },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = false,
                selected = false,
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}