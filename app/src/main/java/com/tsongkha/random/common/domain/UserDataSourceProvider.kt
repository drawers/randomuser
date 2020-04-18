package com.tsongkha.random.common.domain

import com.tsongkha.random.common.network.RemoteUserDataSource
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class UserDataSourceProvider(private val remoteUserDataSource: RemoteUserDataSource) : Provider<UserDataSource> {
    override fun get(): UserDataSource {
        return remoteUserDataSource
    }
}