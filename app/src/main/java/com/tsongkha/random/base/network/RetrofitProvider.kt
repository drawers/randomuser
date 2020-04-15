package com.tsongkha.random.base.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class RetrofitProvider(private val okHttpClient: OkHttpClient) : Provider<Retrofit> {

    override fun get(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://randomuser.me")
        .build()
}