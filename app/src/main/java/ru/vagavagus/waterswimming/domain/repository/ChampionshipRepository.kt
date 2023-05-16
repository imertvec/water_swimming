package ru.vagavagus.waterswimming.domain.repository

import ru.vagavagus.waterswimming.domain.model.Championship

interface ChampionshipRepository {
    suspend fun fetchChampionships(): List<Championship>
}