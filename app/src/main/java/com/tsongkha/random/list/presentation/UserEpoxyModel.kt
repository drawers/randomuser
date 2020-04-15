package com.tsongkha.random.list.presentation

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.tsongkha.random.R
import kotlinx.android.extensions.LayoutContainer

@EpoxyModelClass(layout = R.layout.item_user)
abstract class UserEpoxyModel : EpoxyModelWithHolder<UserEpoxyModel.Holder>() {

    class Holder : BaseEpoxyHolder()
}

abstract class BaseEpoxyHolder : EpoxyHolder(), LayoutContainer {
    lateinit var itemView: View
    override val containerView: View?
        get() = itemView

    override fun bindView(itemView: View) {
        this.itemView = itemView
    }
}