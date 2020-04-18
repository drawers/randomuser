package com.tsongkha.random.base.network.dto

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Dob(
    val date: Date,
    val age: Int
)