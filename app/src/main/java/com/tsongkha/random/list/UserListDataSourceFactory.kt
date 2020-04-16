package com.tsongkha.random.list

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tsongkha.random.base.network.UserService
import com.tsongkha.random.user.User

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