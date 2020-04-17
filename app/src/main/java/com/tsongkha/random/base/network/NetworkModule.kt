package com.tsongkha.random.base.network

import com.squareup.moshi.Moshi
import com.tsongkha.random.list.paging.PagingConfig
import com.tsongkha.random.list.paging.PagingConfigProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

const val RETROFIT = "RETROFIT"

val networkModule = module {
    bind<OkHttpClient>().toProvider(OkHttpClientProvider::class)
    bind<Moshi>().toProvider(MoshiProvider::class)
    bind<Retrofit>().toProvider(RetrofitProvider::class)
    bind<UserService>().withName(RETROFIT).toProvider(UserServiceProvider::class)
    bind<UserService>().toClass<DelayingUserService>()
    bind<PagingConfig>().toProvider(PagingConfigProvider::class)
}