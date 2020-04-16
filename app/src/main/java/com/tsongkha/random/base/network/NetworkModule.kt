package com.tsongkha.random.base.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

val networkModule = module {
    bind<OkHttpClient>().toProvider(OkHttpClientProvider::class)
    bind<Moshi>().toProvider(MoshiProvider::class)
    bind<Retrofit>().toProvider(RetrofitProvider::class)
    bind<UserService>().toProvider(UserServiceProvider::class)
}