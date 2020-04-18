package com.tsongkha.random.feature.list.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.tsongkha.random.common.domain.User
import com.tsongkha.random.common.domain.UserDataSource

class PagedUserDataSourceFactory(
    private val userDataSource: UserDataSource,
    private val paging: Paging
) : DataSource.Factory<Int, User>() {

    private val sourceLiveData = MutableLiveData<PageKeyedUserDataSource>()
    private var latestSourcePageKeyed: PageKeyedUserDataSource? = null

    override fun create(): DataSource<Int, User> {
        return PageKeyedUserDataSource(
            userDataSource = userDataSource,
            paging = paging
        ).also {
            latestSourcePageKeyed = it
            sourceLiveData.postValue(it)
        }
    }
}