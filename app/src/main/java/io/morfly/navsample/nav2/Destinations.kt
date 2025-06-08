package io.morfly.navsample.nav2

import kotlinx.serialization.Serializable

@Serializable
data object DestinationA

@Serializable
data class DestinationB(val number: Int)

@Serializable
data class DestinationC(val number: Int)