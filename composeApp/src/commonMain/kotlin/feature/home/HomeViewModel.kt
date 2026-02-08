package feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import domain.feature.news.GetNewsUseCase
import domain.feature.recommendations.GetRecommendationsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getRecommendations: GetRecommendationsUseCase,
    private val getNews: GetNewsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<HomeState>(HomeState.Loading)
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.value = HomeState.Loading
            combine(
                getRecommendations(),
                getNews()
            ) { recommendations, news ->
                Logger.d("What is news: $news")
                HomeState.Content(recommendations, news)
            }.catch {
                it.message?.let { message -> _uiState.value = HomeState.Error(message) }
            }.collect { state ->
                _uiState.value = state
            }
        }
    }

    fun handleClick() {

    }
}