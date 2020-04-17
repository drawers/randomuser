package com.tsongkha.random.list.paging

import androidx.paging.PageKeyedDataSource
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User
import kotlinx.coroutines.runBlocking

class UserListDataSource(
    private val userService: UserService,
    private val paging: Paging
) : PageKeyedDataSource<Int, User>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = paging.initialPage,
                seed = paging.seed,
                results = paging.pageSize,
                include = null,
                exclude = "registered"
            )
            callback.onResult(
                items.results,
                0,
                paging.maxResults,
                null,
                paging.nextPage(items.info.page)
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = params.key,
                seed = paging.seed,
                results = params.requestedLoadSize,
                include = null,
                exclude = "registered"
            )
            callback.onResult(
                items.results,
                paging.nextPage(items.info.page)
            )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = params.key,
                seed = paging.seed,
                results = params.requestedLoadSize,
                include = null,
                exclude = "registered"
            )
            callback.onResult(
                items.results,
                paging.previousPage(items.info.page)
            )
        }
    }
}