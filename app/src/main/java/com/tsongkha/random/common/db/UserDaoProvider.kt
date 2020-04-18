package com.tsongkha.random.common.db

import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class UserDaoProvider(private val userDatabase: UserDatabase) : Provider<UserDao> {
    override fun get(): UserDao {
        return userDatabase.userDao()
    }
}