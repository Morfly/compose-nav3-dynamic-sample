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

fun DynamicNavBackStackSaver(backStack: NavBackStack): Saver<DynamicNavBackStack, *> = Saver(
    save = { it.dynamicEntries.toMutableMap() },
    restore = { DynamicNavBackStack(backStack, it) },
)
