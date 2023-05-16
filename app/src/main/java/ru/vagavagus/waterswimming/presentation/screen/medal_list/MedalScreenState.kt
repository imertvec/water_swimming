package ru.vagavagus.waterswimming.presentation.screen.medal_list

import ru.vagavagus.waterswimming.domain.model.Medal


sealed class MedalScreenState(state: MedalState) {
    object Loading: MedalScreenState(state = MedalState(isLoading = true))
    class Error(val message: String): MedalScreenState(state = MedalState(error = message, isLoading = false))
    class Success(val data: List<Medal>): MedalScreenState(state = MedalState(isLoading = false, data = data))
}

private data class MedalState(
    val isLoading: Boolean = false,
    val data: List<Medal> = emptyList(),
    val error: String = ""
)
