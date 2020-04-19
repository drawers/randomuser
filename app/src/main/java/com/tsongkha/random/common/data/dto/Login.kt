package com.tsongkha.random.common.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Login(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)