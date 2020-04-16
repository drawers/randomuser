package com.tsongkha.random.base.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import toothpick.InjectConstructor
import java.util.Date
import javax.inject.Provider

@InjectConstructor
class MoshiProvider : Provider<Moshi> {
    override fun get(): Moshi = Moshi.Builder().add(
        Date::class.java,
        Rfc3339DateJsonAdapter().nullSafe()
    ).build()
}