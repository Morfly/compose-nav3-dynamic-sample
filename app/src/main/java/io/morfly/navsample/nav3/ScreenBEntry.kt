package io.morfly.navsample.nav3

import androidx.navigation3.runtime.NavEntry
import io.morfly.navsample.ui.screens.ScreenB

class ScreenBEntry(
    key: DestinationB,
) : NavEntry<DestinationB>(
    key = key,
    content = { ScreenB() }
)
