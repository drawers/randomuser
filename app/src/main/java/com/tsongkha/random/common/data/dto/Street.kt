package com.tsongkha.random.common.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Street(
    val number: Int,
    val name: String
)