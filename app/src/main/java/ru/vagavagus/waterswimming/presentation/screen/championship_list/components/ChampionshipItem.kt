package ru.vagavagus.waterswimming.presentation.screen.championship_list.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import ru.vagavagus.waterswimming.R
import ru.vagavagus.waterswimming.domain.model.Championship
import ru.vagavagus.waterswimming.ui.theme.Bronze
import ru.vagavagus.waterswimming.ui.theme.Gold
import ru.vagavagus.waterswimming.ui.theme.Silver
import ru.vagavagus.waterswimming.ui.theme.WaterSwimmingTheme
import ru.vagavagus.waterswimming.ui.theme.White50

@Composable
fun ChampionshipItem(
    item: Championship
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                .background(White50)
                .padding(start = 20.dp, end = 10.dp, top = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${item.edition}.",
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = item.dates)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = item.year.toString())
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(White50)
                .padding(10.dp)
        ) {
            with(item.location) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(text = stringResource(id = R.string.location))
                    SubcomposeAsyncImage(
                        modifier = Modifier.size(100.dp, 50.dp),
                        model = BitmapFactory.decodeByteArray(item.location.img, 0, item.location.img.size),
                        contentDescription = null,
                        loading = { CircularProgressIndicator() }
                    )
                    Text(
                        text = name,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Divider(
                modifier = Modifier
                    .height(120.dp)
                    .padding(vertical = 10.dp, horizontal = 30.dp)
                    .width(1.dp)
            )
            with(item.details) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        text = stringResource(id = R.string.details),
                        textAlign = TextAlign.Center
                    )
                    Text(text = "${stringResource(id = R.string.athletes)}: $athletes")
                    Text(text = "${stringResource(id = R.string.events)}: $events")
                    Text(text = "${stringResource(id = R.string.events_details)}: $eventsDetails")
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            BottomChampionshipItem(
                modifier = Modifier.weight(.33f),
                winningPlace = stringResource(id = R.string.winner),
                country = item.winner,
                background = Gold
            )
            BottomChampionshipItem(
                modifier = Modifier.weight(.33f),
                winningPlace = stringResource(id = R.string.second),
                country = item.second,
                background = Silver
            )
            BottomChampionshipItem(
                modifier = Modifier.weight(.33f),
                winningPlace = stringResource(id = R.string.third),
                country = item.third,
                background = Bronze
            )
        }
    }

}

@Preview
@Composable
private fun ChampionshipItemPreview() {
    WaterSwimmingTheme {

    }
}