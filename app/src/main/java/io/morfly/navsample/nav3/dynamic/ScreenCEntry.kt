package io.morfly.navsample.nav3.dynamic

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import io.morfly.navsample.common.ui.screens.ScreenC
import io.morfly.navsample.nav3.DestinationB
import io.morfly.navsample.nav3.DestinationC
import kotlinx.serialization.Serializable

@Serializable
class ScreenCEntry(
    override val key: DestinationC
) : DynamicNavEntry {

    override fun value(backStack: DynamicNavBackStack) = NavEntry<NavKey>(
        key = key,
        content = {
            ScreenC(
                number = key.number,
                onNext = {
                    val screenBKey = DestinationB(number = key.number + 1)
                    if (screenBKey !in backStack.entries) {
                        backStack.newEntry(ScreenBEntry(screenBKey))
                    }
                    backStack += screenBKey
                }
            )
        }
    )
}