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

package io.morfly.navsample.nav3.static

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.morfly.navsample.common.ui.screens.ScreenA
import io.morfly.navsample.common.ui.screens.ScreenB
import io.morfly.navsample.common.ui.screens.ScreenC
import io.morfly.navsample.nav3.DestinationA
import io.morfly.navsample.nav3.DestinationB
import io.morfly.navsample.nav3.DestinationC

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
                    ScreenA(onNext = { backStack.add(DestinationB(number = 2)) })
                }

                is DestinationB -> NavEntry(key) {
                    ScreenB(
                        number = key.number,
                        onNext = { backStack.add(DestinationC(number = key.number + 1)) }
                    )
                }

                is DestinationC -> NavEntry(key) {
                    ScreenC(
                        number = key.number,
                        onNext = { backStack.add(DestinationB(number = key.number + 1)) }
                    )
                }

                else -> error("Unknown route: $key")
            }
        }
    )
}