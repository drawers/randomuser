package com.tsongkha.random.list.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User

class UserListDataSourceFactory(
    private val userService: UserService
) : DataSource.Factory<Int, User>() {

    private val sourceLiveData = MutableLiveData<UserListDataSource>()
    private var latestSource: UserListDataSource? = null

    override fun create(): DataSource<Int, User> {
        return UserListDataSource(
            userService = userService
        ).also {
            latestSource = it
            sourceLiveData.postValue(it)
        }
    }
}