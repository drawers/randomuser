package com.tsongkha.random.list.presentation

import com.airbnb.epoxy.TypedEpoxyController
import com.tsongkha.random.user.User

class UsersEpoxyController : TypedEpoxyController<List<User>>() {

    override fun buildModels(data: List<User>?) {
        requireNotNull(data)

        data.forEachIndexed { index, it ->
               user {
                   id(index)
                   titleName(it.name.title + it.name.first + it.name.last)
                   gender(it.gender)
                   dob(it.dob.date)
                   thumbnail(it.picture.thumbnail)
               }
        }
    }
}