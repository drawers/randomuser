package com.tsongkha.random.common.network.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Id(
    val name: String,
    val value: String?
)