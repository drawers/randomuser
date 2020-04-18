package com.tsongkha.random.common.domain

interface UserDataSource {

    suspend fun users(
        page: Int,
        seed: String,
        results: Int,
        exclude: String?,
        include: String?
    ): Result
}