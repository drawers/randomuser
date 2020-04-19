package com.tsongkha.random.common.data.network

import com.tsongkha.random.common.data.dto.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("/api/")
    suspend fun users(
        @Query("page") page: Int,
        @Query("seed") seed: String,
        @Query("results") results: Int,
        @Query("exc") exclude: String?,
        @Query("inc") include: String?
    ): Result
}