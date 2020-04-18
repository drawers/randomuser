package com.tsongkha.random.common.db

import com.tsongkha.random.common.domain.User

//fun UserEntity.toDomain(): User = User(
//    gender = this.gender,
//    name = Name(
//        title = this.title,
//        first = this.firstName,
//        last = this.lastName
//    ),
//    location = Location(
//        street = Street(
//            number = this.streetNumber,
//            name = this.streetName
//        ),
//        city = this.city,
//        state = this.state,
//        country = this.country,
//        postcode = this.postcode
//    ),
//    email = this.email,
//    dob = Dob(date = this.dob, age = this.age),
//    phone = this.phone,
//    login = Login(uuid = this.uuid),
//    cell = this.cell,
//    picture = Picture(
//        large = largeImage,
//        medium = mediumImage,
//        thumbnail = thumbnail
//    ),
//    nat = this.nat
//)

fun User.toUserEntity(id: Int): UserEntity = UserEntity(
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
