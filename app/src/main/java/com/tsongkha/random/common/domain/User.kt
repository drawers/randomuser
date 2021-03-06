package com.tsongkha.random.common.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.Date
import java.util.Locale

@Parcelize
data class User(
    val id: Int,
    val gender: String,
    val name: Name,
    val location: Location,
    val email: String,
    val uuid: String,
    val dob: Date,
    val phone: Phone,
    val picture: Picture,
    val nat: String
) : Parcelable {

    val abbreviatedGender
        get() = gender.take(1).toUpperCase(Locale.ROOT)
}

@Parcelize
data class Name(
    val title: String,
    val first: String,
    val last: String
) : Parcelable {

    val fullName
        get() = "$first $last"
}

@Parcelize
data class Phone(
    val home: String,
    val cell: String
) : Parcelable

@Parcelize
data class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String
) : Parcelable {

    val streetAddress
        get() = "${street.number} ${street.name}\n$city\n$country\n$postcode"
}

@Parcelize
data class Street(
    val number: Int,
    val name: String
) : Parcelable

@Parcelize
data class Picture(
    val large: String,
    val thumbnail: String
) : Parcelable

