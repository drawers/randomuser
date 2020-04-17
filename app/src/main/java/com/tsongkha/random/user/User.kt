package com.tsongkha.random.user

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
data class User(
    val gender: String,
    val name: Name,
    @Embedded
    val location: Location,
    val email: String,
    @Embedded
    val login: Login,
    @Embedded
    val dob: Dob,
    @Embedded
    val registered: Registered,
    val phone: String,
    val cell: String,
    val id: Id,
    @Embedded
    val picture: Picture,
    val nat: String
) {
    @PrimaryKey(autoGenerate = true)
    var entityId: Int = 0
}