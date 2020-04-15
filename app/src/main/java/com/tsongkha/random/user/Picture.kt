package com.tsongkha.random.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)