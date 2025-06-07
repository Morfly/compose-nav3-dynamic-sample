package io.morfly.navsample.nav3.dynamic

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import io.morfly.navsample.common.ui.screens.ScreenB
import io.morfly.navsample.nav3.DestinationB
import kotlinx.serialization.Serializable

@Serializable
class ScreenBEntry(
    override val key: DestinationB
): DynamicNavEntry {

    override fun value(backStack: DynamicNavBackStack) = NavEntry<NavKey>(
        key = key,
        content = { ScreenB(key.number) }
    )
}

