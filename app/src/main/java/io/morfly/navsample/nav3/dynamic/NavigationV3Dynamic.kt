package io.morfly.navsample.nav3.dynamic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.morfly.navsample.nav3.DestinationA

@Composable
fun <T : NavKey> rememberDynamicNavBackStack(vararg elements: T): DynamicNavBackStack {
    val backStack = rememberNavBackStack(*elements)
    return rememberSaveable(saver = DynamicNavBackStackSaver(backStack)) {
        DynamicNavBackStack(backStack)
    }
}

@Composable
fun NavigationV3Dynamic(modifier: Modifier = Modifier) {
    val backStack = rememberDynamicNavBackStack(DestinationA)

    NavDisplay(
        backStack = backStack,
        modifier = modifier,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                DestinationA -> ScreenAEntry().value(backStack)
                else -> {
                    val entry = backStack.entries[key]
                    entry?.value(backStack) ?: error("Unknown route: $key")
                }
            }
        }
    )
}