package com.tsongkha.random.common.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class OkHttpClientProvider : Provider<OkHttpClient> {

    override fun get(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(
                    HttpLoggingInterceptor.Level.HEADERS
                )
            )
            .build()
    }
}