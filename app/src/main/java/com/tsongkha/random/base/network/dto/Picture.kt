package com.tsongkha.random.base.network.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)