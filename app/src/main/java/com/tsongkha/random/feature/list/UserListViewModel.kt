package com.tsongkha.random.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.tsongkha.random.common.domain.User
import com.tsongkha.random.common.domain.UserDataSource
import com.tsongkha.random.feature.list.paging.Paging
import com.tsongkha.random.feature.list.paging.UserListDataSourceFactory
import toothpick.InjectConstructor

@InjectConstructor
class UserListViewModel(
    private val userDataSource: UserDataSource,
    private val paging: Paging
) : ViewModel() {

    val pagedList: LiveData<PagedList<User>> by lazy {
        LivePagedListBuilder<Int, User>(
            UserListDataSourceFactory(
                userDataSource = userDataSource,
                paging = paging
            ),
            PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(paging.pageSize)
                .setInitialLoadSizeHint(paging.pageSize * 2)
                .build()
        ).build()
    }
}