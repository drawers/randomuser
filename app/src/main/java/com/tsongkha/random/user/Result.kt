package com.tsongkha.random.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    val results: List<User>,
    val info: Info
)