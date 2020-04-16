package com.tsongkha.random.user

import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Dob(
    val date: Date,
    val age: Int
)