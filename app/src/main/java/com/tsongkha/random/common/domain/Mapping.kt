package com.tsongkha.random.common.domain

import com.tsongkha.random.list.paging.Paging
import toothpick.InjectConstructor
import com.tsongkha.random.common.network.dto.Info as InfoDto
import com.tsongkha.random.common.network.dto.Result as ResultDto
import com.tsongkha.random.common.network.dto.User as UserDto

@InjectConstructor
class DtoConverter(private val paging: Paging) {

    fun convert(result: ResultDto): Result {
        return Result(
            results = result.results.mapIndexed { index, dto -> dto.toDomain(paging.id(result.info.page, index)) },
            info = result.info.toDomain()
        )
    }

    private fun InfoDto.toDomain(): Info {
        return Info(
            seed = this.seed,
            results = this.results,
            page = this.page,
            version = this.version
        )
    }

    private fun UserDto.toDomain(id: Int): User {
        return User(
            id = id,
            gender = this.gender,
            name = Name(
                title = this.name.title,
                first = this.name.first,
                last = this.name.last
            ),
            location = Location(
                street = Street(this.location.street.number, this.location.street.name),
                city = this.location.city,
                state = this.location.state,
                country = this.location.country,
                postcode = this.location.postcode
            ),
            email = this.email,
            uuid = this.login.uuid,
            dob = this.dob.date,
            phone = Phone(
                home = this.phone,
                cell = this.cell
            ),
            picture = Picture(
                large = this.picture.large,
                thumbnail = this.picture.thumbnail
            ),
            nat = this.nat
        )
    }
}