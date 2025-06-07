package io.morfly.navsample.nav2.static

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.morfly.navsample.common.ui.screens.ScreenA
import io.morfly.navsample.common.ui.screens.ScreenB
import io.morfly.navsample.nav2.DestinationA
import io.morfly.navsample.nav2.DestinationB
import kotlinx.serialization.Serializable


@Composable
fun NavigationV2Static(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = DestinationA, modifier = modifier) {
        composable<DestinationA> { ScreenA(onNext = { navController.navigate(DestinationB(number = 5)) }) }
        composable<DestinationB> { ScreenB(number = 5) }
    }
}

