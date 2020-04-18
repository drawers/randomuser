package com.tsongkha.random.list.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import com.tsongkha.random.BuildConfig
import com.tsongkha.random.domain.User
import java.text.SimpleDateFormat
import java.util.Locale

class PagedUserController() : PagedListEpoxyController<User>() {

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

    private fun user(block: UserModel_.() -> Unit): UserModel {
        return UserModel_().apply { block(this) }
    }

    private fun userPlaceholder(block: UserPlaceholderModel_.() -> Unit): UserPlaceholderModel {
        return UserPlaceholderModel_().apply { block(this) }
    }
}