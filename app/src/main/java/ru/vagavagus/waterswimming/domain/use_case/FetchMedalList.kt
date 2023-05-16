package ru.vagavagus.waterswimming.domain.use_case

import kotlinx.coroutines.flow.flow
import ru.vagavagus.waterswimming.common.RequestResult
import ru.vagavagus.waterswimming.domain.repository.MedalRepository

class FetchMedalList(
    private val repository: MedalRepository
) {
    operator fun invoke() = flow {
        try {
            emit(RequestResult.Loading())
            val data = repository.fetchMedals() ?: emptyList()
            emit(RequestResult.Success(data))
        } catch (e: Exception) {
            emit(RequestResult.Error(message = e.localizedMessage ?: "Read data error"))
        }
    }
}