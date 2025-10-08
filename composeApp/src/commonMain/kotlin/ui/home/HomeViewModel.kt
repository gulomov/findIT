package ui.home

import core.BaseViewModel
import kotlinx.coroutines.flow.Flow

class HomeViewModel() : BaseViewModel<HomeState, HomeEvent, HomeAction>() {
    override val reducer = HomeReducer(HomeState())
    override val state: Flow<HomeState>
        get() = reducer.state

    override fun handleAction(action: HomeAction) {
        when (action) {
            HomeAction.onNewsClick -> {
                // TODO: set action
            }

            HomeAction.onRecommendationsClick -> {
                // TODO: set action

            }
        }
    }
}