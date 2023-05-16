package ru.vagavagus.waterswimming.data.remote

import retrofit2.http.GET

interface MedalApi {

    @GET("/8/medals.json")
    suspend fun fetchMedals(): List<MedalDto>
}