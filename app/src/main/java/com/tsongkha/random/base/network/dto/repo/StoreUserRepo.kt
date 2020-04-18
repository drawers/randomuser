package com.tsongkha.random.base.network.dto.repo

import com.dropbox.android.external.store4.Store
import com.tsongkha.random.base.network.dto.Result
import kotlinx.coroutines.InternalCoroutinesApi
import toothpick.InjectConstructor

@InternalCoroutinesApi
@InjectConstructor
class StoreUserRepo(private val store: Store<Int, Result>) : UserRepo {

    override suspend fun users(page: Int): Result {
        TODO("Not yet implemented")
    }
}