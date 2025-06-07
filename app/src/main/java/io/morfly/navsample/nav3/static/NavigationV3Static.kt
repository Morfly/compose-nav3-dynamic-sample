package io.morfly.navsample.nav3.static

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.morfly.navsample.nav3.DestinationA
import io.morfly.navsample.nav3.DestinationB
import io.morfly.navsample.common.ui.screens.ScreenA
import io.morfly.navsample.common.ui.screens.ScreenB

@Composable
fun NavigationV3Static(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(DestinationA)

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is DestinationA -> NavEntry(key) {
                    ScreenA(onNext = { backStack.add(DestinationB(number = backStack.size + 1)) })
                }

                is DestinationB -> NavEntry(key) {
                    ScreenB(key.number)
                }

                else -> error("Unknown route: $key")
            }
        }
    )
}