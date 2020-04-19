package com.tsongkha.random.common.data.db

import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class UserDaoProvider(private val userDatabase: UserDatabase) : Provider<UserDao> {
    override fun get(): UserDao {
        return userDatabase.userDao()
    }
}