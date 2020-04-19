package com.tsongkha.random.feature.list.paging

import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class PagingProvider : Provider<Paging> {

    override fun get(): Paging = Paging(
        maxResults = 5000,
        pageSize = 50,
        initialPage = 1,
        seed = "abc"
    )
}