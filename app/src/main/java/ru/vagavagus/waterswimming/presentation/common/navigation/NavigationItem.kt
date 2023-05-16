package ru.vagavagus.waterswimming.presentation.common.navigation

import ru.vagavagus.waterswimming.R

sealed class NavigationItem(
    val route: String,
    val icon: Int,
    val title: String
) {
    object Championships: NavigationItem(
        route = "championships_screen",
        icon = R.drawable.chamionship_icon,
        title = "Championships"
    )
    object Medals: NavigationItem(
        route = "medals_screen",
        icon = R.drawable.medal,
        title = "Medals"
    )
}