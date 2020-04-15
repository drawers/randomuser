package com.tsongkha.random.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Timezone(
    val offset: String,
    val description: String
)