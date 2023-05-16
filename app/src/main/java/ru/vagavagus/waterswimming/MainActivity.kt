package ru.vagavagus.waterswimming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.vagavagus.waterswimming.presentation.Screen
import ru.vagavagus.waterswimming.presentation.screen.championship_list.ChampionshipListScreen
import ru.vagavagus.waterswimming.presentation.screen.championship_list.ChampionshipViewModel
import ru.vagavagus.waterswimming.presentation.screen.splash_screen.SplashScreen
import ru.vagavagus.waterswimming.ui.theme.WaterSwimmingTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterSwimmingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.SPLASH.route
                    ) {
                        composable(route = Screen.SPLASH.route) {
                            SplashScreen(
                                onNavigate = { navController.navigate(Screen.CHAMPIONSHIP_LIST.route) }
                            )
                        }
                        composable(route = Screen.CHAMPIONSHIP_LIST.route) {
                            val viewModel = hiltViewModel<ChampionshipViewModel>()
                            val state = viewModel.state.value
                            ChampionshipListScreen(state = state)
                        }
                    }
                }
            }
        }
    }
}