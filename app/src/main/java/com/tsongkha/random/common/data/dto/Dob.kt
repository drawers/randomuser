package com.tsongkha.random.common.data.dto

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Dob(
    val date: Date,
    val age: Int
)