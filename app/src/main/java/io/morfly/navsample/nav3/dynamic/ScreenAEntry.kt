package io.morfly.navsample.nav3.dynamic

import androidx.compose.runtime.saveable.Saver
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import io.morfly.navsample.common.ui.screens.ScreenA
import io.morfly.navsample.nav3.DestinationA
import io.morfly.navsample.nav3.DestinationB

class ScreenAEntry(
    backStack: DynamicBackStack,
) : NavEntry<NavKey>(
    key = DestinationA,
    content = {
        ScreenA(
            onNext = { backStack.newEntry(ScreenBEntry(DestinationB(backStack.size + 1))) }
        )
    }
), SaveableNavEntry {

    override fun saver(backStack: DynamicBackStack): Saver<ScreenAEntry, *> = Saver(
        save = {},
        restore = { ScreenAEntry(backStack) },
    )
}
