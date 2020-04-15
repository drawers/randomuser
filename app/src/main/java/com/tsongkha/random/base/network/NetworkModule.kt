package com.tsongkha.random.base.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.InjectConstructor
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module
import javax.inject.Provider

val networkModule = module {
    bind<Retrofit>().toInstance {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://randomuser.me")
            .build()
    }
    bind<UserService>().toProvider(UserServiceProvider::class)
}

@InjectConstructor
class UserServiceProvider(private val retrofit: Retrofit) : Provider<UserService> {

    override fun get(): UserService {
        return retrofit.create(UserService::class.java)
    }
}