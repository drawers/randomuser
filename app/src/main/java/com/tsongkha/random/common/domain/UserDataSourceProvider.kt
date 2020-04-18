package com.tsongkha.random.common.domain

import com.tsongkha.random.common.db.PersistingUserDataSource
import com.tsongkha.random.common.db.UserDao
import com.tsongkha.random.common.db.UserDatabase
import com.tsongkha.random.common.network.RemoteUserDataSource
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class UserDataSourceProvider(
    private val remoteUserDataSource: RemoteUserDataSource,
    private val userDao: UserDao
) : Provider<UserDataSource> {
    override fun get(): UserDataSource {
        return PersistingUserDataSource(
            userDao = userDao,
            delegate = remoteUserDataSource
        )
    }
}