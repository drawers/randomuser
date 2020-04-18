package com.tsongkha.random.common.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: UserEntity)

    @Query("SELECT * FROM user")
    fun allUsers(): List<UserEntity>

    @Query("SELECT * FROM user WHERE (id >= :start AND id < :endInclusive)")
    fun usersForIds(start: Int, endInclusive: Int): List<UserEntity>
}