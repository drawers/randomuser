package com.tsongkha.random.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Registered(
    val date: String,
    val age: Int
)