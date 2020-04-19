package com.tsongkha.random.common.db

import java.util.SortedMap

class FakeUserDao : UserDao {

    private val inMemoryUsers: SortedMap<Int, UserEntity> = sortedMapOf()

    override fun insert(vararg users: UserEntity) {
        users.forEach {
            inMemoryUsers[it.id] = it
        }
    }

    override fun allUsers(): List<UserEntity> {
        return inMemoryUsers.values.toList()
    }

    override fun usersForIds(start: Int, endInclusive: Int): List<UserEntity> {
        return inMemoryUsers.subMap(start, endInclusive).values.toList()
    }
}