package core

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseReducer<S : State, E : Event>(initialState: S) {
    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state

    fun sendEvent(event: E) {
        reduce(_state.value, event)
    }

    protected fun setState(newState: S) {
        val success = _state.tryEmit(newState)
    }

    protected abstract fun reduce(oldState: S, event: E)
}

interface State

interface Event

interface Action