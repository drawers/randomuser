package com.tsongkha.random.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User
import toothpick.InjectConstructor

const val PAGE_SIZE = 50
const val MAX_RESULTS = 5000

@InjectConstructor
class UserListViewModel(private val userService: UserService) : ViewModel() {

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