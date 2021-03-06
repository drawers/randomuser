package com.tsongkha.random.feature.list.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.tsongkha.random.BuildConfig
import com.tsongkha.random.common.domain.User
import java.text.SimpleDateFormat

class PagedUserController(private val callback: (User) -> Unit) : PagedListEpoxyController<User>() {

    init {
        isDebugLoggingEnabled = true
    }

    private val dateFormat = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT)

    override fun buildItemModel(currentPosition: Int, item: User?): EpoxyModel<*> = when (item) {
        null -> {
            userPlaceholder {
                id(-currentPosition)
            }
        }
        else -> {
            user {
                id(item.id)
                titleName("${item.name.first} ${item.name.last} (${item.name.title}) ${item.id}")
                gender(item.abbreviatedGender)
                dob(dateFormat.format(item.dob))
                thumbnail(item.picture.thumbnail)
                onClick { callback.invoke(item) }
            }
        }
    }

    override fun onExceptionSwallowed(exception: RuntimeException) {
        super.onExceptionSwallowed(exception)
        if (BuildConfig.DEBUG) {
            throw exception
        }
    }

    private fun user(block: UserModel_.() -> Unit): UserModel {
        return UserModel_().apply { block(this) }
    }

    private fun userPlaceholder(block: UserPlaceholderModel_.() -> Unit): UserPlaceholderModel {
        return UserPlaceholderModel_().apply { block(this) }
    }
}