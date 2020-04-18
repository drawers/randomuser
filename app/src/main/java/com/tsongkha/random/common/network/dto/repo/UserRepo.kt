package com.tsongkha.random.common.network.dto.repo

import com.tsongkha.random.common.network.dto.Result

interface UserRepo {

    suspend fun users(page: Int) : Result
}