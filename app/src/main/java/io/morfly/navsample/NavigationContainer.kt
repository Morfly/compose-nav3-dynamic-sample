package io.morfly.navsample

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationContainer(modifier: Modifier = Modifier) {
    // ===== Old compose navigation =====
    // io.morfly.navsample.nav2.static.NavigationV2Static(modifier = modifier)

    // ===== Navigation 3 Static =====
    // io.morfly.navsample.nav3.static.NavigationV3Static(modifier = modifier)

    // ===== Navigation 3 Static =====
    io.morfly.navsample.nav3.dynamic.NavigationV3Dynamic(modifier = modifier)
}