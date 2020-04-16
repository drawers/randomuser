package com.tsongkha.random.list

import androidx.paging.PageKeyedDataSource
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User
import kotlinx.coroutines.runBlocking
import toothpick.InjectConstructor

@InjectConstructor
class UserListDataSource(private val userService: UserService) : PageKeyedDataSource<Int, User>() {

    private var pageSize: Int = PAGE_SIZE

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        runBlocking {
            val items = userService.users(page = 1, seed = "abc", results = params.requestedLoadSize, include = null, exclude = null)
            callback.onResult(
                items.results,
                items.info.page,
                items.info.results
            )
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(page = params.key, seed = "abc", results = params.requestedLoadSize, include = null, exclude = null)
            callback.onResult(
                items.results,
                items.info.page + 1
            )
        }
    }

    private fun nextPage(currentPage: Int): Int {
        return (currentPage + 1).coerceAtMost(totalPages())
    }

    private fun totalPages(): Int {
        return MAX_RESULTS / pageSize
    }

    private fun previousPage(currentPage: Int): Int {
        return (currentPage - 1).coerceAtLeast(1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        runBlocking {
            val items = userService.users(page = params.key, seed = "abc", results = params.requestedLoadSize, include = null, exclude = null)
            callback.onResult(
                items.results,
                previousPage(items.info.page)
            )
        }
    }
}