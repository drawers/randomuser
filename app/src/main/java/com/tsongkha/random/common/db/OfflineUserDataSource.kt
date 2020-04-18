package com.tsongkha.random.common.db

import com.tsongkha.random.common.domain.Info
import com.tsongkha.random.common.domain.Result
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.feature.list.paging.Paging
import toothpick.InjectConstructor

@InjectConstructor
class OfflineUserDataSource(
    private val userDao: UserDao,
    private val paging: Paging
) : UserDataSource {

    override suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        val range = paging.idsForPage(page)
        val users = userDao.usersForIds(range.first, range.last)
        return Result(
            results = users.map { it.toDomain() },
            info = Info(
                seed = seed,
                results = paging.pageSize,
                page = page,
                version = "db"
            )
        )
    }
}