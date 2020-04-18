package com.tsongkha.random.common.db

import com.tsongkha.random.common.domain.Result
import com.tsongkha.random.common.domain.UserDataSource
import toothpick.InjectConstructor

@InjectConstructor
class PersistingUserDataSource(
    private val userDao: UserDao,
    private val delegate: UserDataSource
) : UserDataSource by delegate {

    override suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        val result = delegate.users(page, seed, results, exclude, include)
        userDao.insert(*result.results.map { it.toUserEntity() }.toTypedArray())
        return result
    }
}