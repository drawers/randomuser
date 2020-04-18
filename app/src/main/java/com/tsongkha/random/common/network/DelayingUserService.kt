package com.tsongkha.random.base.network

import com.tsongkha.random.domain.DtoConverter
import kotlinx.coroutines.delay
import toothpick.InjectConstructor
import javax.inject.Named
import com.tsongkha.random.domain.Result

@InjectConstructor
class DelayingUserService(
    @Named(RETROFIT) private val userService: UserService,
    private val dtoConverter: DtoConverter
) {

    suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        delay(2000)
        val result = userService.users(page, seed, results, exclude, include)
        return dtoConverter.convert(result)
    }
}