package com.tsongkha.random.common.network

import com.squareup.moshi.Moshi
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.common.domain.UserDataSourceProvider
import com.tsongkha.random.feature.list.paging.Paging
import com.tsongkha.random.feature.list.paging.PagingProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module

val networkModule = module {
    bind<OkHttpClient>().toProvider(OkHttpClientProvider::class)
    bind<Moshi>().toProvider(MoshiProvider::class)
    bind<Retrofit>().toProvider(RetrofitProvider::class)
    bind<UserService>().toProvider(UserServiceProvider::class)
    bind<UserDataSource>().toProvider(UserDataSourceProvider::class)
    bind<Paging>().toProvider(PagingProvider::class)
}