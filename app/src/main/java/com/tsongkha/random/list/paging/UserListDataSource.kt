package com.tsongkha.random.list.paging

import androidx.paging.PageKeyedDataSource
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User
import kotlinx.coroutines.runBlocking

class UserListDataSource(
    private val userService: UserService,
    private val pagingConfig: PagingConfig
) : PageKeyedDataSource<Int, User>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = pagingConfig.initialPage,
                seed = pagingConfig.seed,
                results = pagingConfig.pageSize,
                include = null,
                exclude = "registered"
            )
            callback.onResult(
                items.results,
                0,
                pagingConfig.maxResults,
                null,
                pagingConfig.nextPage(items.info.page)
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = params.key,
                seed = pagingConfig.seed,
                results = params.requestedLoadSize,
                include = null,
                exclude = "registered"
            )
            callback.onResult(
                items.results,
                pagingConfig.nextPage(items.info.page)
            )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = params.key,
                seed = pagingConfig.seed,
                results = params.requestedLoadSize,
                include = null,
                exclude = "registered"
            )
            callback.onResult(
                items.results,
                pagingConfig.previousPage(items.info.page)
            )
        }
    }
}