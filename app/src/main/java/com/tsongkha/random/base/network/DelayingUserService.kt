package com.tsongkha.random.base.network

import com.tsongkha.random.list.paging.Paging
import com.tsongkha.random.user.Result
import kotlinx.coroutines.delay
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class DelayingUserService(
    @Named(RETROFIT) private val userService: UserService,
    private val paging: Paging
) : UserService {

    override suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        delay(2000)
        val result = userService.users(page, seed, results, exclude, include)
        result.results.forEachIndexed { index, user ->
            user.id = paging.id(page, index)
        }
        return result
    }
}