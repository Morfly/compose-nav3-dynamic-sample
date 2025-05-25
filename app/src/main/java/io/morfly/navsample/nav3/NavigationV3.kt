package io.morfly.navsample.nav3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.morfly.navsample.ui.screens.ScreenA
import io.morfly.navsample.ui.screens.ScreenB
import kotlinx.serialization.Serializable

@Serializable
data object DestinationA : NavKey

@Serializable
data object DestinationB : NavKey

@Composable
fun NavigationV3(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(DestinationA)

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                DestinationA -> NavEntry(key) {
                    ScreenA(onNext = { backStack.add(DestinationB) })
                }

                DestinationB -> NavEntry(key) {
                    ScreenB()
                }

                else -> error("Unknown route: $key")
            }
        }
    )
}