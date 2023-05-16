package ru.vagavagus.waterswimming.domain.repository

import ru.vagavagus.waterswimming.domain.model.Medal

interface MedalRepository {
    suspend fun fetchMedals(): List<Medal>
}