package com.tsongkha.random.list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedList
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User
import kotlinx.coroutines.runBlocking
import toothpick.InjectConstructor

const val PAGE_SIZE = 50
const val MAX_RESULTS = 5000

class UsersViewModel(private val userService: UserService) : ViewModel() {

    val pagedList: LiveData<PagedList<User>> by lazy {
        LivePagedListBuilder<Int, User>(
            UserListDataSourceFactory(userService),
            PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(PAGE_SIZE)
                .setInitialLoadSizeHint(PAGE_SIZE * 2)
                .build()
        ).build()
    }
}

class UserListDataSourceFactory(private val userService: UserService) : DataSource.Factory<Int, User>() {
    val sourceLiveData = MutableLiveData<UserListDataSource>()
    var latestSource: UserListDataSource? = null

    override fun create(): DataSource<Int, User> {
        return UserListDataSource(userService = userService).also {
            latestSource = it
            sourceLiveData.postValue(it)
        }
    }
}

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