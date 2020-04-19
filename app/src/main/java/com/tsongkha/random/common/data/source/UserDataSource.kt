package com.tsongkha.random.common.data.source

import com.tsongkha.random.common.domain.Result

interface UserDataSource {

    suspend fun users(
        page: Int,
        seed: String,
        results: Int,
        exclude: String?,
        include: String?
    ): Result
}