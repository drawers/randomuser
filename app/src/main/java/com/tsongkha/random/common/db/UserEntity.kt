package com.tsongkha.random.base.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user")
data class UserEntity(
    val uuid: String,
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
    val dob: Date,
    val phone: String,
    val cell: String,
    val largeImage: String,
    val thumbnail: String,
    val nat: String,
    @PrimaryKey
    val id: Int
)