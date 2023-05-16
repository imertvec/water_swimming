package ru.vagavagus.waterswimming.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.vagavagus.waterswimming.data.room.entities.ChampionshipEntity
import ru.vagavagus.waterswimming.data.room.entities.CountryEntity
import ru.vagavagus.waterswimming.data.room.entities.LocationEntity

@Database(
    entities = [
        ChampionshipEntity::class,
        CountryEntity::class,
        LocationEntity::class
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val championshipDao: ChampionshipDao
    abstract val locationDao: LocationDao
    abstract val countryDao: CountryDao
}