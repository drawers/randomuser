package com.tsongkha.random.common.data.db

import android.content.Context
import androidx.room.Room
import com.tsongkha.random.common.application.APPLICATION
import toothpick.InjectConstructor
import javax.inject.Named
import javax.inject.Provider

@InjectConstructor
class DbProvider(@Named(APPLICATION) private val context: Context) : Provider<UserDatabase> {
    override fun get(): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            "users"
        ).build()
    }
}