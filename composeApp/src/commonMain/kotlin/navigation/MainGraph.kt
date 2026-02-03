package navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import feature.home.HomeScreen as HomeScreenComposable
import feature.favorite.FavoriteScreen as FavoriteScreenComposable

fun NavGraphBuilder.mainGraph(navController: NavController) {
    composable(
        route = ScreenRoute.HOME,
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
        HomeScreenComposable(navController)
    }

    composable(
        route = ScreenRoute.FAVORITE,
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
        FavoriteScreenComposable(navController)
    }
}