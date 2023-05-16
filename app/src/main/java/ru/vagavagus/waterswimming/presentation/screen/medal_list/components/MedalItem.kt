package ru.vagavagus.waterswimming.presentation.screen.medal_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import ru.vagavagus.waterswimming.domain.model.Medal
import ru.vagavagus.waterswimming.ui.theme.Bronze
import ru.vagavagus.waterswimming.ui.theme.Gold
import ru.vagavagus.waterswimming.ui.theme.Silver
import ru.vagavagus.waterswimming.ui.theme.WaterSwimmingTheme
import ru.vagavagus.waterswimming.ui.theme.White50

@Composable
fun MedalItem(
    item: Medal
) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(5.dp))
            .background(White50)
            .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = item.nation,
            fontSize = 18.sp
        )
        Row(
            modifier = Modifier
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier.size(100.dp, 50.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.img)
                    .build(),
                loading = { CircularProgressIndicator() },
                contentDescription = null,
                error = { Icon(
                    imageVector = Icons.Outlined.Warning,
                    contentDescription = null
                ) }
            )
            Column {
                MedalText(
                    text = item.gold.toString(),
                    color = Gold
                )
                MedalText(
                    text = item.silver.toString(),
                    color = Silver
                )
                MedalText(
                    text = item.bronze.toString(),
                    color = Bronze
                )
                MedalText(
                    text = item.total.toString(),
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun MedalItemPreview() {
    WaterSwimmingTheme {
        MedalItem(
            item = Medal(
                nation = "United States",
                gold = 268,
                silver = 218,
                bronze = 167,
                total = 671,
                img = ""
            )
        )
    }
}