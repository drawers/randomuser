package com.tsongkha.random.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.list.paging.PAGE_SIZE
import com.tsongkha.random.list.paging.UserListDataSourceFactory
import com.tsongkha.random.user.User
import toothpick.InjectConstructor

@InjectConstructor
class UserListViewModel(private val userService: UserService) : ViewModel() {

    val pagedList: LiveData<PagedList<User>> by lazy {
        LivePagedListBuilder<Int, User>(
            UserListDataSourceFactory(
                userService = userService
            ),
            PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(PAGE_SIZE)
                .setInitialLoadSizeHint(PAGE_SIZE * 2)
                .build()
        ).build()
    }
}