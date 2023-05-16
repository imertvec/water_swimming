package ru.vagavagus.waterswimming.data.room

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.vagavagus.waterswimming.data.room.entities.LOCATION_TABLE
import ru.vagavagus.waterswimming.data.room.entities.LocationEntity

@Dao
interface LocationDao {

    @Query("SELECT * FROM $LOCATION_TABLE")
    fun selectAll(): Flow<List<LocationEntity>>

    @Query("SELECT * FROM $LOCATION_TABLE WHERE location_id == :locationId")
    fun selectById(locationId: Long): LocationEntity
}