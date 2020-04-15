package com.tsongkha.random.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Dob(
    val date: String,
    val age: Int
)