package navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ui.home.HomeScreen

fun NavGraphBuilder.mainGraph(navController: NavController) {
    composable<HomeScreen>(
        enterTransition = {
            slideIntoContainer(
                animationSpec = tween(300, easing = FastOutSlowInEasing),
                towards = AnimatedContentTransitionScope.SlideDirection.Left
            )
        },
        exitTransition = {
            slideOutOfContainer(
                animationSpec = tween(300, easing = FastOutSlowInEasing),
                towards = AnimatedContentTransitionScope.SlideDirection.Left
            )
        }
    ) {
        HomeScreen(navController)
    }
}