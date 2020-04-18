package com.tsongkha.random.feature.list.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tsongkha.random.common.domain.User
import com.tsongkha.random.common.domain.UserDataSource

class UserListDataSourceFactory(
    private val userDataSource: UserDataSource,
    private val paging: Paging
) : DataSource.Factory<Int, User>() {

    private val sourceLiveData = MutableLiveData<UserListDataSource>()
    private var latestSource: UserListDataSource? = null

    override fun create(): DataSource<Int, User> {
        return UserListDataSource(
            userDataSource = userDataSource,
            paging = paging
        ).also {
            latestSource = it
            sourceLiveData.postValue(it)
        }
    }
}