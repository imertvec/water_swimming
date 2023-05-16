package ru.vagavagus.waterswimming.data.repository

import ru.vagavagus.waterswimming.data.remote.MedalApi
import ru.vagavagus.waterswimming.data.remote.MedalDto
import ru.vagavagus.waterswimming.domain.model.Medal
import ru.vagavagus.waterswimming.domain.repository.MedalRepository

class MedalRepositoryImpl(
    private val api: MedalApi
): MedalRepository {
    override suspend fun fetchMedals(): List<Medal> {
        return api.fetchMedals().map { it.toMedal() }
    }

    //MARK: fun-converter
    private fun MedalDto.toMedal() = Medal(nation, gold, img, silver, bronze, total)
}