package ru.vagavagus.waterswimming.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.vagavagus.waterswimming.presentation.screen.MainScreen
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
                        startDestination = TopScreen.SPLASH.route
                    ) {
                        composable(route = TopScreen.SPLASH.route) {
                            SplashScreen(
                                onNavigate = {
                                    navController.navigate(TopScreen.MAIN.route) {
                                        popUpTo(TopScreen.SPLASH.route) {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                        }
                        composable(route = TopScreen.MAIN.route) {
                            MainScreen()
                        }
                    }
                }
            }
        }
    }
}