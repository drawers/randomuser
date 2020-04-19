package com.tsongkha.random.common.data.source

import com.tsongkha.random.common.data.db.UserDao
import com.tsongkha.random.common.data.db.toEntity
import com.tsongkha.random.common.domain.Result
import toothpick.InjectConstructor
import javax.inject.Named

@InjectConstructor
class PersistingUserDataSource(
    private val userDao: UserDao,
    @Named(REMOTE) private val delegate: UserDataSource
) : UserDataSource by delegate {

    override suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        val result = delegate.users(page, seed, results, exclude, include)
        userDao.insert(*result.results.map { it.toEntity() }.toTypedArray())
        return result
    }
}