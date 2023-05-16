package ru.vagavagus.waterswimming.domain.model

data class Location(
    val name: String,
    val img: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Location

        if (name != other.name) return false
        return img.contentEquals(other.img)
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + img.contentHashCode()
        return result
    }
}
