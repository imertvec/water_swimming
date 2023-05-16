package ru.vagavagus.waterswimming.data.repository

import ru.vagavagus.waterswimming.data.room.ChampionshipDao
import ru.vagavagus.waterswimming.data.room.CountryDao
import ru.vagavagus.waterswimming.data.room.LocationDao
import ru.vagavagus.waterswimming.data.room.entities.ChampionshipEntity
import ru.vagavagus.waterswimming.data.room.entities.CountryEntity
import ru.vagavagus.waterswimming.data.room.entities.LocationEntity
import ru.vagavagus.waterswimming.domain.model.Championship
import ru.vagavagus.waterswimming.domain.model.Country
import ru.vagavagus.waterswimming.domain.model.Details
import ru.vagavagus.waterswimming.domain.model.Location
import ru.vagavagus.waterswimming.domain.repository.ChampionshipRepository

class ChampionshipRepositoryImpl(
    private val championshipDao: ChampionshipDao,
    private val locationDao: LocationDao,
    private val countryDao: CountryDao
): ChampionshipRepository {

    override suspend fun fetchChampionships(): List<Championship> {
        return championshipDao.selectAll().map { it.toChampionship() }
    }

    //MARK: fun-converters
    private fun ChampionshipEntity.toChampionship() = Championship(
        year = year,
        dates = dates,
        edition = edition,
        location = locationDao.selectById(locationId).toLocation(),
        details = Details(
            athletes,
            events,
            eventsDetails
                .replace(" (M)", "M")
                .replace(" (W)", "W")
                .replace(" (X)", "X")
        ),
        winner = countryDao.selectById(winnerId).toCountry(),
        second = countryDao.selectById(secondId).toCountry(),
        third = countryDao.selectById(thirdId).toCountry()
    )

    private fun LocationEntity.toLocation() = Location(
        name = name.replace(", ", ", \n"),
        img = imageBytes
    )

    private fun CountryEntity.toCountry() = Country(name, imageBytes)
}