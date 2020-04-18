package com.tsongkha.random.common

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import kotlinx.android.extensions.LayoutContainer

abstract class BaseEpoxyHolder : EpoxyHolder(), LayoutContainer {
    lateinit var itemView: View
    override val containerView: View?
        get() = itemView

    override fun bindView(itemView: View) {
        this.itemView = itemView
    }
}