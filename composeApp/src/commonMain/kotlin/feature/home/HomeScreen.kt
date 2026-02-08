package feature.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import feature.home.components.RecommendationItem
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
                HomeContent(
                    content = (state as HomeState.Content),
                    onClick = viewModel::handleClick
                )
            }

            is HomeState.Error -> {}

            is HomeState.Loading -> {}
        }
    }
}

@Composable
private fun HomeContent(
    content: HomeState.Content,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        items(items = content.recommendations, key = { "${it.id}+ ${it.brand}" }) {
            RecommendationItem(
                recommendation = it,
                onItemClick = {}
            )
        }

        items(items = content.news, key = { "${it.id}+ ${it.title}" }) {
            Text(
                text = it.title
            )
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