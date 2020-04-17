package com.tsongkha.random.list.paging

import toothpick.InjectConstructor
import javax.inject.Provider

@InjectConstructor
class PagingConfigProvider : Provider<PagingConfig> {

    override fun get(): PagingConfig = PagingConfig(
        maxResults = 200,
        pageSize = 50,
        initialPage = 1,
        seed = "abc"
    )
}