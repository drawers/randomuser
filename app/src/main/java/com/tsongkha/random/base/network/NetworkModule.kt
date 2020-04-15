package com.tsongkha.random.base.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

val networkModule = module {
    bind<OkHttpClient>().toProvider(OkHttpClientProvider::class)
    bind<Retrofit>().toProvider(RetrofitProvider::class)
    bind<UserService>().toProvider(UserServiceProvider::class)
}