package feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import domain.feature.recommendations.GetRecommendationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getRecommendations: GetRecommendationsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeState>(HomeState.Loading)
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getRecommendations()
                .onStart { _uiState.value = HomeState.Loading }
                .catch { it.message?.let { message -> _uiState.value = HomeState.Error(message) } }
                .collect {
                    Logger.d { " data: $it" }
                    _uiState.value = HomeState.Content(it)
                }
        }
    }

}