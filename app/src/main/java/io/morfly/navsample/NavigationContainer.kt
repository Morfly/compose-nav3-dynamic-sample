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
    // val navImplementation = NavImplementation.Nav2Static

    // ===== Navigation 3 Static =====
    // val navImplementation = NavImplementation.Nav3Static

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