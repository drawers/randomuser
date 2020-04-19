package com.tsongkha.random.common.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Coordinates(
    val latitude: Double,
    val longitude: Double
)