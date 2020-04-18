package com.tsongkha.random.domain

interface UserDataSource {

    suspend fun users(
        page: Int,
        seed: String,
        results: Int,
        exclude: String?,
        include: String?
    ): Result
}