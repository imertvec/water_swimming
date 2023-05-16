package ru.vagavagus.waterswimming.data.room

import androidx.room.Dao
import androidx.room.Query
import ru.vagavagus.waterswimming.data.room.entities.CHAMPIONSHIPS_TABLE
import ru.vagavagus.waterswimming.data.room.entities.ChampionshipEntity

@Dao
interface ChampionshipDao {

    @Query("SELECT * FROM $CHAMPIONSHIPS_TABLE")
    fun selectAll(): List<ChampionshipEntity>
}