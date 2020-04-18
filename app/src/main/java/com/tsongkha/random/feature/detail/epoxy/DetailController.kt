package com.tsongkha.random.feature.detail.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.tsongkha.random.common.domain.User

class DetailController : TypedEpoxyController<User>() {

    override fun buildModels(data: User?) {
        requireNotNull(data)
    }
}