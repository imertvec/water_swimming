package ru.vagavagus.waterswimming.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val COUNTRY_TABLE = "country"

@Entity(tableName = COUNTRY_TABLE)
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "country_id") val countryId: Long,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(
        name = "image_bytes",
        typeAffinity = ColumnInfo.BLOB
    ) val imageBytes: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CountryEntity

        if (countryId != other.countryId) return false
        if (name != other.name) return false
        return imageBytes.contentEquals(other.imageBytes)
    }

    override fun hashCode(): Int {
        var result = countryId.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + imageBytes.contentHashCode()
        return result
    }
}
