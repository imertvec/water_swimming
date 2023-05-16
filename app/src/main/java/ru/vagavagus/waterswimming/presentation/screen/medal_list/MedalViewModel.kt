package ru.vagavagus.waterswimming.presentation.screen.medal_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.vagavagus.waterswimming.common.RequestResult
import ru.vagavagus.waterswimming.domain.use_case.FetchMedalList
import javax.inject.Inject

@HiltViewModel
class MedalViewModel @Inject constructor(
    private val fetchMedalListUseCase: FetchMedalList
): ViewModel() {

    private val _state: MutableStateFlow<MedalScreenState> = MutableStateFlow(MedalScreenState.Loading)
    val state: StateFlow<MedalScreenState> = _state

    init {
        viewModelScope.launch {
            fetchMedalListUseCase().collect { result ->
                when(result) {
                    is RequestResult.Error -> _state.update { MedalScreenState.Error(result.message!!) }
                    is RequestResult.Loading -> _state.update { MedalScreenState.Loading }
                    is RequestResult.Success -> _state.update { MedalScreenState.Success(data = result.data!!) }
                }
            }
        }
    }
}