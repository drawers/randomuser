package com.tsongkha.random.base.network.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    val results: List<User>,
    val info: Info
)