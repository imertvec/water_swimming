package ru.vagavagus.waterswimming.data.remote

import com.squareup.moshi.Json

data class MedalDto(
    @Json(name = "nation") val nation: String,
    @Json(name = "img")val img: String,
    @Json(name = "gold")val gold: Int,
    @Json(name = "silver")val silver: Int,
    @Json(name = "bronze")val bronze: Int,
    @Json(name = "total")val total: Int
)