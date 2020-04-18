package com.tsongkha.random.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coordinates(
    val latitude: Double,
    val longitude: Double
)