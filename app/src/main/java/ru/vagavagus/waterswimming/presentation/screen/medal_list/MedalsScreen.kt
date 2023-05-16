package ru.vagavagus.waterswimming.presentation.screen.medal_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vagavagus.waterswimming.presentation.screen.medal_list.components.MedalItem
import ru.vagavagus.waterswimming.ui.theme.LightBlue
import ru.vagavagus.waterswimming.ui.theme.WaterSwimmingTheme

@Composable
fun MedalsScreen(
    state: MedalScreenState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
    ) {
        when(state) {
            is MedalScreenState.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            is MedalScreenState.Error -> Text(text = state.message)
            is MedalScreenState.Success -> {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                ) {
                    items(state.data) {
                        MedalItem(item = it)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun MedalsScreenPreview() {
    WaterSwimmingTheme {
        MedalsScreen(
            state = MedalScreenState.Loading
        )
    }
}