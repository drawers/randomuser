package com.tsongkha.random.base.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    val gender: String,
    val firstName: String,
    val lastName: String,
    val title: String,
    val streetNumber: Int,
    val streetName: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val email: String,
    val dob: String,
    val age: Int,
    val phone: String,
    val cell: String,
    val mediumImage: String,
    val largeImage: String,
    val thumbnail: String,
    val nat: String
) {
    @PrimaryKey(autoGenerate = true)
    var primaryKey: Int = 0
}