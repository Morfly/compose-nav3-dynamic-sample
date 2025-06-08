@file:Suppress("KotlinConstantConditions")

package io.morfly.navsample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.morfly.navsample.nav2.static.NavigationV2Static
import io.morfly.navsample.nav3.dynamic.NavigationV3Dynamic
import io.morfly.navsample.nav3.static.NavigationV3Static

enum class NavImplementation(
    val displayName: String,
    val content: @Composable () -> Unit
) {
    Nav2Static("Static Navigation 2", content = { NavigationV2Static() }),
    Nav3Static("Static Navigation 3", content = { NavigationV3Static() }),
    Nav3Dynamic("Dynamic Navigation 3", content = { NavigationV3Dynamic() })
}

@Composable
fun NavigationContainer(modifier: Modifier = Modifier) {
    // ===== Old Compose Navigation =====
    // val nav = NavImplementation.Nav2Static

    // ===== Navigation 3 Static =====
    // val nav = NavImplementation.Nav3Static

    // ===== Navigation 3 Dynamic =====
    val navImplementation = NavImplementation.Nav3Dynamic

    NavigationContainer(modifier, navImplementation)
}

@Composable
private fun NavigationContainer(
    modifier: Modifier,
    navImplementation: NavImplementation
) {
    Column(
        modifier = modifier.padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = navImplementation.displayName,
            style = MaterialTheme.typography.labelMedium,
        )
        navImplementation.content()
    }
}