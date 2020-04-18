package com.tsongkha.random.common.network

import com.tsongkha.random.common.domain.Result
import com.tsongkha.random.common.domain.UserDataSource

class SwitchingUserDataSource(
    private val connectivity: Connectivity,
    private val remoteUserDataSource: RemoteUserDataSource
) : UserDataSource {

    override suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        return when {
            connectivity.isConnected() -> {
                remoteUserDataSource.users(page, seed, results, exclude, include)
            }
            else -> {
                remoteUserDataSource.users(page, seed, results, exclude, include)
            }
        }
    }
}