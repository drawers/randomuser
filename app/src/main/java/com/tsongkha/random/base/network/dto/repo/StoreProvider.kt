package com.tsongkha.random.base.network.dto.repo

import com.dropbox.android.external.store4.Store
import com.dropbox.android.external.store4.StoreBuilder
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.base.network.dto.Result
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import toothpick.InjectConstructor
import javax.inject.Provider

@ExperimentalCoroutinesApi
@FlowPreview
@ExperimentalStdlibApi
@InjectConstructor
class StoreProvider(private val userService: UserService) : Provider<Store<Int, Result>> {

    override fun get(): Store<Int, Result> {
        return StoreBuilder.fromNonFlow<Int, Result> { page ->
            userService.users(
                page = page,
                seed = "abc",
                results = 5000,
                exclude = null,
                include = null
            )
        }.build()
    }
}