import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import data.di.dataModule
import di.firebaseModule
import di.provideHttpClientModule
import domain.di.domainModule
import org.jetbrains.compose.ui.tooling.preview.Preview

import navigation.AppNavHost
import org.koin.compose.KoinApplication
import ui.di.featureViewModel

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(
            firebaseModule,
            provideHttpClientModule,
            domainModule,
            dataModule,
            featureViewModel
        )
    }) {
        MaterialTheme {
            AppNavHost()
        }
    }
}