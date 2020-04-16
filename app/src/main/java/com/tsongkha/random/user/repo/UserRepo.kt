package com.tsongkha.random.user.repo

import com.tsongkha.random.user.Result

interface UserRepo {

    suspend fun users(page: Int) : Result
}