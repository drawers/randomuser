package com.tsongkha.random.list.paging

import androidx.paging.PageKeyedDataSource
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User
import kotlinx.coroutines.runBlocking

private const val TOTAL_PAGES = MAX_RESULTS / PAGE_SIZE

class UserListDataSource(
    private val userService: UserService
) : PageKeyedDataSource<Int, User>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = INITIAL_PAGE,
                seed = SEED,
                results = PAGE_SIZE,
                include = null,
                exclude = "login, registered"
            )
            callback.onResult(
                items.results,
                0,
                MAX_RESULTS,
                null,
                nextPage(1)
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = params.key,
                seed = SEED,
                results = params.requestedLoadSize,
                include = null,
                exclude = "login, registered"
            )
            callback.onResult(
                items.results,
                nextPage(items.info.page)
            )
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(
                page = params.key,
                seed = SEED,
                results = params.requestedLoadSize,
                include = null,
                exclude = "login, registered"
            )
            callback.onResult(
                items.results,
                previousPage(items.info.page)
            )
        }
    }

    private fun nextPage(currentPage: Int): Int? {
        val next = currentPage + 1
        return if (next < TOTAL_PAGES) return next else null
    }

    private fun previousPage(currentPage: Int): Int? {
        val previous = currentPage - 1
        return if (previous <= 0) null else previous
    }
}