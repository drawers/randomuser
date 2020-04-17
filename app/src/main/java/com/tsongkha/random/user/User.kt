package com.tsongkha.random.user

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val dob: Dob,
    val phone: String,
    val login: Login,
    val cell: String,
    val picture: Picture,
    val nat: String
) {
    @Transient
    var id: Int = 0
}