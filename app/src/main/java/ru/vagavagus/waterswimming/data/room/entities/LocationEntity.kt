package ru.vagavagus.waterswimming.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val LOCATION_TABLE = "location"

@Entity(tableName = LOCATION_TABLE)
data class LocationEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "location_id") val locationId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(
        name = "image_bytes",
        typeAffinity = ColumnInfo.BLOB
    ) val imageBytes: ByteArray

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LocationEntity

        if (locationId != other.locationId) return false
        if (name != other.name) return false
        return imageBytes.contentEquals(other.imageBytes)
    }

    override fun hashCode(): Int {
        var result = locationId.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + imageBytes.contentHashCode()
        return result
    }
}
