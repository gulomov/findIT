package core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : State, E : Event, A : Action> : ViewModel() {
    abstract val state: Flow<S>
    abstract val reducer: BaseReducer<S, @UnsafeVariance E>
    private val actionFlow = MutableSharedFlow<A>()

    abstract fun handleAction(action: A)

    init {
        subscribeToActions()
    }

    private fun subscribeToActions() {
        viewModelScope.launch {
            actionFlow.collect { handleAction(it) }
        }
    }

    protected fun sendEvent(event: E) {
        println("Event: $event")
        reducer.sendEvent(event)
    }

    fun sendAction(action: A) {
        println("Action: $action")
        viewModelScope.launch { actionFlow.emit(action) }
    }
}