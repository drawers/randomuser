package com.tsongkha.random.common.data.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class RetrofitProvider(
    private val okHttpClient: OkHttpClient,
    private val moshi: Moshi
) : Provider<Retrofit> {

    override fun get(): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://randomuser.me")
        .build()
}