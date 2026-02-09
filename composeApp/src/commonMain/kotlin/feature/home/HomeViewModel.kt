package feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import domain.feature.news.GetNewsUseCase
import domain.feature.recommendations.GetRecommendationsUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getRecommendations: GetRecommendationsUseCase,
    private val getNews: GetNewsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeState>(HomeState.Loading)
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    init {
        exampleWithFlow()
    }

    private fun exampleWithFlow() {
        viewModelScope.launch {
            try {
                flow {
                    _uiState.value = HomeState.Loading
                    emit(getRecommendations() to getNews())
                }.collect { state ->
                    _uiState.value = HomeState.Content(state.first, state.second)
                }
            } catch (error: Exception) {
                _uiState.value = HomeState.Error(error.message.orEmpty())
            }
        }
    }

    private fun exampleWithAsync() {
        viewModelScope.launch {
            _uiState.value = HomeState.Loading
            try {
                val recommendationsDeferred = async { getRecommendations() }
                val newsDeferred = async { getNews() }

                val recommendations = recommendationsDeferred.await()
                val news = newsDeferred.await()

                _uiState.value = HomeState.Content(recommendations, news)
            } catch (e: Exception) {
                _uiState.value = HomeState.Error(e.message ?: "Unknown error")
            }
        }
    }

    fun handleClick() {

    }
}