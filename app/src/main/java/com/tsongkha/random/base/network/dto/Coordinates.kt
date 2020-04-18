package com.tsongkha.random.base.network.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coordinates(
    val latitude: Double,
    val longitude: Double
)