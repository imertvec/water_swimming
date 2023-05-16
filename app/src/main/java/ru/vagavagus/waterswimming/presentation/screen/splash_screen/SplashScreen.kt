package ru.vagavagus.waterswimming.presentation.screen.splash_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ru.vagavagus.waterswimming.R
import ru.vagavagus.waterswimming.ui.theme.LightBlue
import ru.vagavagus.waterswimming.ui.theme.Ulove
import ru.vagavagus.waterswimming.ui.theme.WaterSwimmingTheme

@Composable
fun SplashScreen(
    onNavigate: () -> Unit
) {
    LaunchedEffect(key1 = true) {
        delay(1000)
        onNavigate()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontFamily = Ulove,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )
        Image(
            painter = painterResource(id = R.drawable.swimming_logo),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    WaterSwimmingTheme {
        SplashScreen(
            onNavigate = {}
        )
    }
}