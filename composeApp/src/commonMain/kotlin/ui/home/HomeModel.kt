package ui.home

import androidx.compose.runtime.Immutable
import core.Action
import core.Event
import core.State

sealed interface HomeAction : Action {
    data object onNewsClick : HomeAction
    data object onRecommendationsClick : HomeAction
}

sealed interface HomeEvent : Event {
    object onNewsClicked : HomeEvent
    object onRecommendationsClicked : HomeEvent
}

@Immutable
data class HomeState(
    val recommendationsState: RecommendationsState = RecommendationsState()
) : State

@Immutable
data class RecommendationsState(
    val recommendationsList: List<Recommendation> = emptyList()
)

@Immutable
data class Recommendation(
    val id: Int = 0,
    val image: String = "",
    val brand: String = "",
)