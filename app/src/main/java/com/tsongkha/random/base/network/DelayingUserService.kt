package com.tsongkha.random.base.network

import com.tsongkha.random.user.Result
import kotlinx.coroutines.delay
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class DelayingUserService(@Named(RETROFIT) private val userService: UserService) : UserService {

    override suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        delay(4000)
        return userService.users(page, seed, results, exclude, include)
    }
}