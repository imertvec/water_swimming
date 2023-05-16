package ru.vagavagus.waterswimming.presentation.screen.championship_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vagavagus.waterswimming.common.RequestResult
import ru.vagavagus.waterswimming.domain.use_case.FetchChampionships
import javax.inject.Inject

@HiltViewModel
class ChampionshipViewModel @Inject constructor(
    private val fetchChampionshipsUseCase: FetchChampionships
): ViewModel() {

    private val _state = MutableStateFlow(ChampionshipState())
    val state: StateFlow<ChampionshipState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            fetchChampionshipsUseCase().collect { result ->
                when(result) {
                    is RequestResult.Loading -> _state.value = _state.value.copy(isLoading = true)
                    is RequestResult.Error -> _state.value = _state.value.copy(error = result.message!!)
                    is RequestResult.Success -> _state.value = _state.value.copy(isLoading = false, data = result.data ?: emptyList())
                }
            }
        }
    }
}