package com.tsongkha.random.base.network.dto.repo

import com.tsongkha.random.base.network.dto.Result

interface UserRepo {

    suspend fun users(page: Int) : Result
}