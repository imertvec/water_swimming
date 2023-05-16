package ru.vagavagus.waterswimming.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

const val CHAMPIONSHIPS_TABLE = "championships"

@Entity(
    tableName = CHAMPIONSHIPS_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = LocationEntity::class,
            parentColumns = ["location_id"],
            childColumns = ["location_id"]
        ),
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["country_id"],
            childColumns = ["winner_id"]
        ),
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["country_id"],
            childColumns = ["second_id"]
        ),
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["country_id"],
            childColumns = ["third_id"]
        )
    ],
    indices = [
        Index(
            "location_id",
            "winner_id",
            "second_id",
            "third_id"
        )
    ]
)
data class ChampionshipEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "championship_id") val championshipId: Long,
    @ColumnInfo(name = "year") val year: Int,
    @ColumnInfo(name = "dates") val dates: String,
    @ColumnInfo(name = "edition") val edition: Int,
    @ColumnInfo(name = "location_id") val locationId: Long,
    @ColumnInfo(name = "athletes") val athletes: Int,
    @ColumnInfo(name = "events") val events: Int,
    @ColumnInfo(name = "events_details") val eventsDetails: String,
    @ColumnInfo(name = "winner_id") val winnerId: Long,
    @ColumnInfo(name = "second_id") val secondId: Long,
    @ColumnInfo(name = "third_id") val thirdId: Long
)