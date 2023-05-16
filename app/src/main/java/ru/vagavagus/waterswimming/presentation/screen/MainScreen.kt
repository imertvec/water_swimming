package ru.vagavagus.waterswimming.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import ru.vagavagus.waterswimming.presentation.common.navigation.BottomNavigationBar
import ru.vagavagus.waterswimming.presentation.common.navigation.Navigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { padding ->
        Box(modifier = Modifier.padding(paddingValues = padding)) {
            Navigation(navController)
        }
    }
}