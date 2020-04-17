package com.tsongkha.random.base.db

import androidx.room.RoomDatabase

abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}