package com.tsongkha.random.list.presentation

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.tsongkha.random.BuildConfig
import com.tsongkha.random.user.User

class PagedUserController : PagedListEpoxyController<User>() {

    override fun buildItemModel(currentPosition: Int, item: User?): EpoxyModel<*> = when (item) {
        null -> {
            user {
                id(-currentPosition)
                titleName("loading")
                dob("loading")
                gender("m")
            }
        }
        else -> {
            user {
                id(item.login.uuid)
                titleName(item.name.title + item.name.first + item.name.last)
                gender(item.gender)
                dob(item.dob.date)
                thumbnail(item.picture.thumbnail)
            }
        }
    }

    override fun onExceptionSwallowed(exception: RuntimeException) {
        super.onExceptionSwallowed(exception)
        if (BuildConfig.DEBUG) {
            throw exception
        }
    }

    private fun user(block: UserEpoxyModel_.() -> Unit): UserEpoxyModel {
        return UserEpoxyModel_().apply { block(this) }
    }
}