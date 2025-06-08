/*
 * Copyright 2025 Pavlo Stavytskyi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
                    val entry = backStack.dynamicEntries[key]
                    entry?.value(backStack) ?: error("Unknown route: $key")
                }
            }
        }
    )
}