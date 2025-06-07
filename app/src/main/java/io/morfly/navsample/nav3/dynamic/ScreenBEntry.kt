package io.morfly.navsample.nav3.dynamic

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import io.morfly.navsample.common.ui.screens.ScreenB
import io.morfly.navsample.nav3.DestinationB

class ScreenBEntry(
    override val key: DestinationB,
) : NavEntry<NavKey>(
    key = key,
    content = { ScreenB(key.number) }
), SaveableNavEntry {

    override fun saver(backStack: DynamicBackStack): Saver<ScreenBEntry, DestinationB> = Saver(
        save = { it.key },
        restore = { ScreenBEntry(it) },
    )
}
