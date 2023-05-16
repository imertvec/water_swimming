package ru.vagavagus.waterswimming.presentation.screen.championship_list

import ru.vagavagus.waterswimming.domain.model.Championship

data class ChampionshipState(
    val isLoading: Boolean = false,
    val data: List<Championship> = emptyList(),
    val error: String = ""
)
