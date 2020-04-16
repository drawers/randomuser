package com.tsongkha.random.list.presentation

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.tsongkha.random.BuildConfig
import com.tsongkha.random.user.User
import java.lang.RuntimeException

class PagedUserController : PagedListEpoxyController<User>() {

    override fun buildItemModel(currentPosition: Int, item: User?): EpoxyModel<*> {
        TODO("Not yet implemented")
    }

    override fun onExceptionSwallowed(exception: RuntimeException) {
        super.onExceptionSwallowed(exception)
        if (BuildConfig.DEBUG) {
            throw exception
        }
    }
}