package com.tsongkha.random.common.data.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val login: Login,
    val dob: Dob,
    val phone: String,
    val cell: String,
    val id: Id,
    val picture: Picture,
    val nat: String
)