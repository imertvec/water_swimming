package ru.vagavagus.waterswimming.domain.use_case

import kotlinx.coroutines.flow.channelFlow
import ru.vagavagus.waterswimming.common.RequestResult
import ru.vagavagus.waterswimming.domain.repository.ChampionshipRepository

class FetchChampionships(
    private val repository: ChampionshipRepository
) {
    operator fun invoke() = channelFlow {
        try {
            send(RequestResult.Loading())
            val data = repository.fetchChampionships()
            send(RequestResult.Success(data = data))
        } catch (e: Exception) {
            send(RequestResult.Error(message = e.localizedMessage ?: "Request error"))
        }
    }
}