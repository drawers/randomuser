package com.tsongkha.random.common.db

import android.content.Context
import androidx.room.Room
import com.tsongkha.random.common.application.APPLICATION
import javax.inject.Named
import javax.inject.Provider

class DbProvider(@Named(APPLICATION) private val context: Context) : Provider<UserDatabase> {
    override fun get(): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "users"
        ).build()
    }
}