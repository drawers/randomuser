package com.tsongkha.random.common.data.source

import com.tsongkha.random.common.domain.DtoConverter
import com.tsongkha.random.common.domain.Result
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.common.network.UserService
import toothpick.InjectConstructor
import javax.inject.Inject

@InjectConstructor
class RemoteUserDataSource(
    private val userService: UserService,
    private val dtoConverter: DtoConverter
) : UserDataSource {

    override suspend fun users(
        page: Int,
        seed: String,
        results: Int,
        exclude: String?,
        include: String?
    ): Result {
        return dtoConverter.convert(
            userService.users(
                page, seed, results, exclude, include
            )
        )
    }
}