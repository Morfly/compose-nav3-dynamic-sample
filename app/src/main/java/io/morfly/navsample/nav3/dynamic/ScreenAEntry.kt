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

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import io.morfly.navsample.common.ui.screens.ScreenA
import io.morfly.navsample.nav3.DestinationA
import io.morfly.navsample.nav3.DestinationB
import kotlinx.serialization.Serializable

@Serializable
class ScreenAEntry : DynamicNavEntry {
    override val key = DestinationA

    override fun value(backStack: DynamicNavBackStack) = NavEntry<NavKey>(
        key = key,
        content = {
            ScreenA(
                onNext = {
                    val screenBKey = DestinationB(number = 2)
                    if (screenBKey !in backStack.dynamicEntries) {
                        backStack.newEntry(ScreenBEntry(screenBKey))
                    }
                    backStack += screenBKey
                }
            )
        }
    )
}
