package com.tsongkha.random.common.data.source

import com.tsongkha.random.common.domain.Result
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.common.network.Connectivity
import javax.inject.Named

class NaiveSwitchingUserDataSource(
    private val connectivity: Connectivity,
    @Named(REMOTE_PERSISTING) private val remoteUserDataSource: UserDataSource,
    @Named(OFFLINE) private val offlineUserDataSource: UserDataSource
) : UserDataSource {

    override suspend fun users(page: Int, seed: String, results: Int, exclude: String?, include: String?): Result {
        return when {
            connectivity.isConnected() -> {
                remoteUserDataSource.users(page, seed, results, exclude, include)
            }
            else -> {
                offlineUserDataSource.users(page, seed, results, exclude, include)
            }
        }
    }
}