package com.tsongkha.random.base.db

import android.content.Context
import androidx.room.Room
import com.tsongkha.random.base.application.APPLICATION
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