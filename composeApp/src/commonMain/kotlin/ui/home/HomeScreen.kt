package ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import co.touchlab.kermit.Logger
import domain.feature.recommendations.model.Recommendation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    AnimatedContent(
        targetState = state,
        modifier = modifier
    ) {
        when (state) {
            is HomeState.Content -> {
                HomeContent(recommendations = (state as HomeState.Content).recommendations)
            }

            is HomeState.Error -> {
                Logger.d {
                    " error: ${(state as HomeState.Error).message}"
                }
            }

            is HomeState.Loading -> {

            }
        }
    }
}

@Composable
private fun HomeContent(
    recommendations: List<Recommendation>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hello")
        Button(
            onClick = { }
        ) {
            Text("Click to log")
        }
    }
}

@Preview
@Composable
private fun HomePreview() {
    MaterialTheme {
        HomeScreen(
            navController = rememberNavController()
        )
    }
}