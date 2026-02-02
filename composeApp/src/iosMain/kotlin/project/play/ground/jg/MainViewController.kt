package project.play.ground.jg

import App
import androidx.compose.ui.window.ComposeUIViewController
import di.initKoin

private var koinInitialized = false

fun MainViewController() = ComposeUIViewController { 
    if (!koinInitialized) {
        initKoin()
        koinInitialized = true
    }
    App() 
}