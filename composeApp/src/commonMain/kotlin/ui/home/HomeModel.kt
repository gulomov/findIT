package ui.home

import androidx.compose.runtime.Immutable
import domain.feature.recommendations.model.Recommendation


sealed interface HomeEvent {
    fun setRecommendations(recommendation: List<Recommendation>): HomeEvent
}

sealed interface HomeState {
    data object Loading : HomeState

    data class Error(
        val message: String,
    ): HomeState

    @Immutable
    data class Content(
        val recommendations: List<Recommendation> = emptyList()
    ) : HomeState

}