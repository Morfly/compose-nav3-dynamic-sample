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

@file:Suppress("FunctionName")

package io.morfly.navsample.nav3.dynamic

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey

interface DynamicNavEntry {
    val key: NavKey
    fun value(backStack: DynamicNavBackStack): NavEntry<NavKey>
}

class DynamicNavBackStack(
    private val internalBackStack: NavBackStack,
    private val entries: MutableMap<NavKey, DynamicNavEntry> = mutableMapOf()
) : MutableList<NavKey> by internalBackStack {

    val dynamicEntries: Map<NavKey, DynamicNavEntry>
        get() = entries

    fun newEntry(entry: DynamicNavEntry) {
        entries[entry.key] = entry
    }
}

fun DynamicNavBackStackSaver(
    internalBackStack: NavBackStack
): Saver<DynamicNavBackStack, *> = Saver(
    save = { it.dynamicEntries.toMutableMap() },
    restore = { DynamicNavBackStack(internalBackStack, it) },
)
