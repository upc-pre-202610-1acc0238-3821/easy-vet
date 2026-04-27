package pe.edu.upc.easyvet.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import pe.edu.upc.easyvet.R
import kotlin.reflect.KClass

@Serializable
object HomeGraph

@Serializable
object FavoritesGraph

@Serializable
object CartGraph

@Serializable
object ProfileGraph

@Composable
fun Main() {
    val tabNavController = rememberNavController()

    Scaffold (bottomBar = {
        MainBottomBar (tabNavController)
    }) { paddingValues ->
        NavHost(
            navController = tabNavController,
            startDestination = HomeGraph,
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}

@Composable
fun MainBottomBar(navController: NavController) {
    val tabs = listOf(
        MainTab(
            title = "Home",
            route = HomeGraph,
            routeClass = HomeGraph::class,
            icon = {
                Icon(painter = painterResource(R.drawable.visibility), contentDescription = "Home")
            }
        )
    )
}

data class MainTab<T: Any> (
    val title: String,
    val route: T,
    val routeClass: KClass<T>,
    val icon: @Composable () -> Unit
)
