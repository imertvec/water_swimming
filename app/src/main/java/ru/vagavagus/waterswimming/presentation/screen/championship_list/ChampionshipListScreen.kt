package ru.vagavagus.waterswimming.presentation.screen.championship_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.vagavagus.waterswimming.R
import ru.vagavagus.waterswimming.presentation.screen.championship_list.components.ChampionshipItem
import ru.vagavagus.waterswimming.ui.theme.LightBlue

@Composable
fun ChampionshipListScreen(
    state: ChampionshipState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue)
    ) {
        if(state.isLoading)
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        if(state.error.isNotEmpty())
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = state.error
            )
        if(state.data.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            ) {
                item { 
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.championships),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
                items(state.data) {
                    ChampionshipItem(item = it)
                }
            }
        }
    }
}