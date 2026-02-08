package navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector
import navigation.ScreenRoute.FAVORITE

enum class BottomBarScreen(
    val title: String,
    val route: Any,
    val defaultIcon: ImageVector,
    val activeIcon: ImageVector,
) {
    Home(
        title = "Home",
        route = ScreenRoute.HOME,
        defaultIcon = Icons.Outlined.Home,
        activeIcon = Icons.Filled.Home,
    ),

    Favorites(
        title = "Favorites",
        route = FAVORITE,
        defaultIcon = Icons.Outlined.FavoriteBorder,
        activeIcon = Icons.Filled.Favorite
    )
}

object ScreenRoute {
    const val INTRO_ROUTE = "intro"
    const val INTRO_SPLASH = "splash"
    const val INTRODUCTION = "introduction"
    const val HOME = "home"
    const val PRODUCTION_DETAIL = "detail/{productId}"
    const val FAVORITE = "favorite"
    const val NEWS_DETAILS = "news/{newsId}"
    const val RECOMMENDATION_DETAILS = "recommendations/{brandName}"
    const val GALLERY = "gallery/{brand}"
}