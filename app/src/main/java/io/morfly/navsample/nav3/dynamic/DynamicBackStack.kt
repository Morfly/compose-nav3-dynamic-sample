package io.morfly.navsample.nav3.dynamic

import androidx.compose.foundation.text.input.TextFieldState.Saver.save
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey

interface SaveableNavEntry {
    fun saver(backStack: DynamicBackStack): Saver<out SaveableNavEntry, *>
}

class DynamicBackStack(
    private val navBackStack: NavBackStack,
    private val mutableEntries: MutableMap<NavKey, SaveableNavEntry> = mutableMapOf()
) : List<NavKey> by navBackStack {

    val entries: Map<NavKey, SaveableNavEntry> = mutableEntries

    fun newEntry(entry: NavEntry<NavKey>) {
        navBackStack += entry.key
        if (entry is SaveableNavEntry) {
            mutableEntries[entry.key] = entry
        }
    }
}

fun DynamicBackStackSaver(navBackStack: NavBackStack): Saver<DynamicBackStack, Any> = listSaver(
    save = {
        val savedEntries = it.entries.values
            .mapNotNull { entry ->
                val saver = entry.saver(it) as Saver<SaveableNavEntry, *>
                with(saver) { save(entry) }
            }
        savedEntries
    },
    restore = {
        val restoredEntries = it.mapNotNull { entry ->
            val saver =
        }
        DynamicBackStack(navBackStack)
    },
)

//fun DynamicBackStackSaver(navBackStack: NavBackStack): Saver<DynamicBackStack, List<SaveableNavEntry>> = listSaver(
//    save = {
//        val savedEntries = it.entries.values
//            .map { entry ->
//                val saver = entry.saver(it) as Saver<SaveableNavEntry, *>
//                with(saver) { save(entry) }
//            }
//        TODO()
//    },
//    restore = { DynamicBackStack(navBackStack) },
//)

//fun DynamicBackStackSaver(navBackStack: NavBackStack): Saver<DynamicBackStack, *> = Saver(
//    save = { it.entries.filterValues { entry -> entry is SaveableNavEntry } },
//    restore = { DynamicBackStack(navBackStack) },
//)

