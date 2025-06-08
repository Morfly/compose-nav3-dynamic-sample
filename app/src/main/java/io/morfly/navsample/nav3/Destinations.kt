package io.morfly.navsample.nav3

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object DestinationA : NavKey

@Serializable
data class DestinationB(val number: Int) : NavKey

@Serializable
data class DestinationC(val number: Int) : NavKey