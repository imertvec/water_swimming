package ru.vagavagus.waterswimming.data.room

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.vagavagus.waterswimming.data.room.entities.COUNTRY_TABLE
import ru.vagavagus.waterswimming.data.room.entities.CountryEntity

@Dao
interface CountryDao {

    @Query("SELECT * FROM $COUNTRY_TABLE")
    fun selectAll(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM $COUNTRY_TABLE WHERE country_id == :countryId")
    fun selectById(countryId: Long): CountryEntity
}