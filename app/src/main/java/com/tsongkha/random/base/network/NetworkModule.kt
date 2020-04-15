package com.tsongkha.random.base.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

val networkModule = module {
    bind<OkHttpClient>().toProvider(OkHttpClientProvider::class)
    bind<Retrofit>().toInstance {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://randomuser.me")
            .build()
    }
    bind<UserService>().toProvider(UserServiceProvider::class)
}