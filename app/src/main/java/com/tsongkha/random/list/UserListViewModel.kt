package com.tsongkha.random.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.list.paging.PagingConfig
import com.tsongkha.random.list.paging.UserListDataSourceFactory
import com.tsongkha.random.user.User
import toothpick.InjectConstructor

@InjectConstructor
class UserListViewModel(
    private val userService: UserService,
    private val pagingConfig: PagingConfig
) : ViewModel() {

    val pagedList: LiveData<PagedList<User>> by lazy {
        LivePagedListBuilder<Int, User>(
            UserListDataSourceFactory(
                userService = userService,
                pagingConfig = pagingConfig
            ),
            PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(pagingConfig.pageSize)
                .setInitialLoadSizeHint(pagingConfig.pageSize * 2)
                .build()
        ).build()
    }
}