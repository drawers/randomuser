package com.tsongkha.random.feature.detail.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.tsongkha.random.common.domain.User

class DetailController : TypedEpoxyController<User>() {

    override fun buildModels(data: User?) {
        requireNotNull(data)

        name {
            id("name")
            name(data.name.fullName)
            titleGender("${data.name.title} (${data.abbreviatedGender})")
            pictureUrl(data.picture.large)
        }

        location {
            id("location")
            address(data.location.streetAddress)
        }

        phone {
            id("phone")
            home(data.phone.home)
            cell(data.phone.cell)
        }
    }
}