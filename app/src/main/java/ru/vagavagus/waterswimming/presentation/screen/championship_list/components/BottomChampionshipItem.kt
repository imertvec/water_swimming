package ru.vagavagus.waterswimming.presentation.screen.championship_list.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import ru.vagavagus.waterswimming.domain.model.Country
import ru.vagavagus.waterswimming.ui.theme.WaterSwimmingTheme

@Composable
fun BottomChampionshipItem(
    winningPlace: String,
    country: Country,
    modifier: Modifier = Modifier,
    background: Color
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp))
            .background(background)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = winningPlace)
            SubcomposeAsyncImage(
                modifier = Modifier.size(75.dp, 37.5f.dp),
                model = BitmapFactory.decodeByteArray(country.img, 0, country.img.size),
                loading = { CircularProgressIndicator() },
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(5.dp),
                text = country.name,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun BottomChampionshipItemPreview() {
    WaterSwimmingTheme {
        BottomChampionshipItem(
            winningPlace = "Winner",
            country = Country(
                "United States",
                img = ByteArray(2)
            ),
            background = Color.White
        )
    }
}