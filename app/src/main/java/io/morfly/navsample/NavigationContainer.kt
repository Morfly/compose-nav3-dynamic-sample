package io.morfly.navsample

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NavigationContainer(modifier: Modifier = Modifier) {
    // ===== Old compose navigation =====
    // io.morfly.navsample.nav2.NavigationV2(modifier = modifier)

    // ===== Navigation 3 =====
    io.morfly.navsample.nav3.NavigationV3(modifier = modifier)
}