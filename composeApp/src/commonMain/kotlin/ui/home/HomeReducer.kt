package ui.home

import core.BaseReducer

class HomeReducer(initialState: HomeState) : BaseReducer<HomeState, HomeEvent>(initialState) {
    override fun reduce(
        oldState: HomeState,
        event: HomeEvent
    ) {
        when (event) {
            is HomeEvent.onNewsClicked -> {
                // TODO: setState()
            }

            is HomeEvent.onRecommendationsClicked -> {
                // TODO: setState()
            }
        }
    }
}