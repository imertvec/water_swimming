package ru.vagavagus.waterswimming.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.vagavagus.waterswimming.presentation.screen.championship_list.ChampionshipListScreen
import ru.vagavagus.waterswimming.presentation.screen.championship_list.ChampionshipViewModel
import ru.vagavagus.waterswimming.presentation.screen.medal_list.MedalViewModel
import ru.vagavagus.waterswimming.presentation.screen.medal_list.MedalsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavigationItem.Championships.route
    ) {
        composable(route = NavigationItem.Championships.route) {
            val viewModel = hiltViewModel<ChampionshipViewModel>()
            val state = viewModel.state.collectAsState().value
            ChampionshipListScreen(state = state)
        }
        composable(route = NavigationItem.Medals.route) {
            val viewModel = hiltViewModel<MedalViewModel>()
            val state = viewModel.state.collectAsState().value
            MedalsScreen(state = state)
        }
    }
}