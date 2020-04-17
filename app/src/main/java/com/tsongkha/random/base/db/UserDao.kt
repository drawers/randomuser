package com.tsongkha.random.base.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tsongkha.random.user.User

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg users: User)

    @Query("SELECT * FROM user")
    fun allUsers(): List<User>
}