package io.morfly.navsample.nav2.static

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import io.morfly.navsample.common.ui.screens.ScreenA
import io.morfly.navsample.common.ui.screens.ScreenB
import io.morfly.navsample.common.ui.screens.ScreenC
import io.morfly.navsample.nav2.DestinationA
import io.morfly.navsample.nav2.DestinationB
import io.morfly.navsample.nav2.DestinationC

@Composable
fun NavigationV2Static(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DestinationA,
        modifier = modifier
    ) {
        composable<DestinationA> {
            ScreenA(onNext = { navController.navigate(DestinationB(number = 2)) })
        }
        composable<DestinationB> {
            val number = it.toRoute<DestinationB>().number
            ScreenB(
                number = number,
                onNext = { navController.navigate(DestinationC(number = number + 1)) }
            )
        }
        composable<DestinationC> {
            val number = it.toRoute<DestinationC>().number
            ScreenC(
                number = number,
                onNext = { navController.navigate(DestinationB(number = number + 1)) }
            )
        }
    }
}

