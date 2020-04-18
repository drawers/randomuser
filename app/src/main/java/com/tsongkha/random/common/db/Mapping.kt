package com.tsongkha.random.common.db

import com.tsongkha.random.common.domain.Location
import com.tsongkha.random.common.domain.Name
import com.tsongkha.random.common.domain.Phone
import com.tsongkha.random.common.domain.Picture
import com.tsongkha.random.common.domain.Street
import com.tsongkha.random.common.domain.User

fun UserEntity.toDomain(): User = User(
    id = this.id,
    gender = this.gender,
    name = Name(this.title, this.firstName, this.lastName),
    location = Location(Street(this.streetNumber, this.streetName), this.city, this.state, this.country, this.postcode),
    email = this.email,
    uuid = this.uuid,
    dob = this.dob,
    phone = Phone(this.phone, this.cell),
    picture = Picture(this.largeImage, this.thumbnail),
    nat = this.nat
)

fun User.toEntity(): UserEntity = UserEntity(
    id = this.id,
    uuid = this.uuid,
    gender = this.gender,
    firstName = this.name.first,
    lastName = this.name.last,
    title = this.name.title,
    streetNumber = this.location.street.number,
    streetName = this.location.street.name,
    city = this.location.city,
    state = this.location.state,
    country = this.location.country,
    postcode = this.location.postcode,
    email = this.email,
    dob = this.dob,
    phone = this.phone.home,
    cell = this.phone.cell,
    largeImage = this.picture.large,
    thumbnail = this.picture.thumbnail,
    nat = this.nat
)
