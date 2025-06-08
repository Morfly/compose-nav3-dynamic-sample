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
