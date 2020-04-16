package com.tsongkha.random.list.presentation

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.tsongkha.random.BuildConfig
import com.tsongkha.random.user.User
import java.text.SimpleDateFormat
import java.util.Locale

class PagedUserController() : PagedListEpoxyController<User>() {

    private val dateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT)

    override fun buildItemModel(currentPosition: Int, item: User?): EpoxyModel<*> = when (item) {
        null -> {
            user {
                id(-currentPosition)
                titleName("loading")
                dob("loading")
                gender("m")
                thumbnail("")
            }
        }
        else -> {
            user {
                id(item.login.uuid)
                titleName("${item.name.first} ${item.name.last} (${item.name.title})")
                gender(item.gender.take(1).toUpperCase(Locale.ROOT))
                dob(dateFormat.format(item.dob.date))
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