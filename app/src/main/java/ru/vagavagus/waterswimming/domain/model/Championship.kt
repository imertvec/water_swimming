package ru.vagavagus.waterswimming.domain.model

data class Championship(
    val year: Int,
    val dates: String,
    val edition: Int,
    val location: Location,
    val details: Details,
    val winner: Country,
    val second: Country,
    val third: Country
)