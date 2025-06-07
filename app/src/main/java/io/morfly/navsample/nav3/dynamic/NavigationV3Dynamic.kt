package io.morfly.navsample.nav3.dynamic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.morfly.navsample.nav3.DestinationA

@Composable
fun NavigationV3Dynamic(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStack(DestinationA)
    val dynamicBackStack = remember { DynamicBackStack(backStack) }

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                DestinationA -> ScreenAEntry(dynamicBackStack)
                else -> dynamicBackStack.entries[key] ?: error("Unknown route: $key")
            }
        }
    )
}