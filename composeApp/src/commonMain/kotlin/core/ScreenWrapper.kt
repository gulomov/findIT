package core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
inline fun <S : State, E : Event, reified A : Action> ScreenWrapper(
    viewModel: BaseViewModel<S, E, A>,
    showFullscreenLoading: Boolean = false,
    onScreenEnter: Action? = null,
    onScreenLeft: Action? = null,
    crossinline content: @Composable (sendAction: (A) -> Unit) -> Unit,
) {
    val sendAction: (A) -> Unit = { action ->
        viewModel.sendAction(action)
    }

    DisposableEffect(Unit) {
        if (onScreenEnter is A) {
            sendAction(onScreenEnter)
        }

        onDispose {
            if (onScreenLeft is A) {
                sendAction(onScreenLeft)
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        content(sendAction)

        if (showFullscreenLoading) {
            FullscreenLoading()
        }
    }
}

@Composable
fun FullscreenLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f)),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}