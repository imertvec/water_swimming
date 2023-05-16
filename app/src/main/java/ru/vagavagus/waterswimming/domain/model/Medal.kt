package ru.vagavagus.waterswimming.domain.model

data class Medal(
    val nation: String,
    val gold: Int,
    val img: String,
    val silver: Int,
    val bronze: Int,
    val total: Int
)
