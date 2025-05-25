package io.morfly.navsample.nav2

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.morfly.navsample.ui.screens.ScreenA
import io.morfly.navsample.ui.screens.ScreenB
import kotlinx.serialization.Serializable

@Serializable
data object DestinationA

@Serializable
data object DestinationB

@Composable
fun NavigationV2(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DestinationA, modifier = modifier) {
        composable<DestinationA> { ScreenA(onNext = { navController.navigate(DestinationB) }) }
        composable<DestinationB> { ScreenB() }
    }
}

