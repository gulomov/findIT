package navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import navigation.ScreenRoute.FAVORITE
import navigation.ScreenRoute.HOME

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route
    
    Scaffold(
        modifier = modifier,
        bottomBar = {
            if (currentRoute == ScreenRoute.HOME || currentRoute == ScreenRoute.FAVORITE) {
                BottomNavigationBar(
                    navController = navController
                )
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = HOME,
            modifier = Modifier.padding(contentPadding),
        ) {
            mainGraph(navController)
        }
    }
}

@Composable
private fun BottomNavigationBar(navController: NavController) {
    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    NavigationBar {
        BottomBarScreen.entries.forEach { tab ->
            val isSelected = isCurrentRoute(currentRoute, tab.route)
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (isSelected) {
                            tab.activeIcon
                        } else {
                            tab.defaultIcon
                        },
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        text = tab.title,
                        style = TextStyle(
                            fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Thin
                        )
                    )
                },
                selected = isSelected,
                onClick = {
                    navigateBottomBar(
                        navController = navController,
                        destination = tab.route
                    )
                }
            )
        }
    }
}

fun navigateBottomBar(navController: NavController, destination: Any) {
    navController.navigate(destination.toString()) {
        popUpTo(HOME) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

private fun isCurrentRoute(currentRoute: String?, target: Any): Boolean {
    return currentRoute == target.toString()
}