package com.tsongkha.random.common.data.source

import com.tsongkha.random.common.db.UserDao
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.common.network.Connectivity
import toothpick.InjectConstructor
import javax.inject.Named
import javax.inject.Provider

@InjectConstructor
class UserDataSourceProvider(
    private val connectivity: Connectivity,
    @Named(REMOTE_PERSISTING) private val remoteUserDataSource: UserDataSource,
    @Named(OFFLINE) private val offlineUserDataSource: UserDataSource
) : Provider<UserDataSource> {
    override fun get(): UserDataSource {
        return NaiveSwitchingUserDataSource(
            connectivity = connectivity,
            remoteUserDataSource = remoteUserDataSource,
            offlineUserDataSource = offlineUserDataSource
        )
    }
}