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
    internal val mutableEntries: MutableMap<NavKey, DynamicNavEntry> = mutableMapOf()
) : MutableList<NavKey> by internalBackStack {

    val entries: Map<NavKey, DynamicNavEntry>
        get() = mutableEntries

    fun newEntry(entry: DynamicNavEntry) {
        if (entry.key !in mutableEntries){
            mutableEntries[entry.key] = entry
        }
    }
}

fun DynamicNavBackStackSaver(backStack: NavBackStack): Saver<DynamicNavBackStack, *> = Saver(
    save = { it.mutableEntries },
    restore = { DynamicNavBackStack(backStack, it) },
)
