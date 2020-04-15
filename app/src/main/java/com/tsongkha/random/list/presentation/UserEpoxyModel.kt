package com.tsongkha.random.list.presentation

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.tsongkha.random.R
import kotlinx.android.extensions.LayoutContainer

@EpoxyModelClass(layout = R.layout.item_user)
abstract class UserEpoxyModel : EpoxyModelWithHolder<UserEpoxyModel.Holder>() {

    @EpoxyAttribute
    lateinit var titleName: String

    @EpoxyAttribute
    lateinit var thumbnail: String

    @EpoxyAttribute
    lateinit var dob: String

    @EpoxyAttribute
    lateinit var gender: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder.itemView) {
            findViewById<TextView>(R.id.nameTextView).text = titleName
            findViewById<TextView>(R.id.genderTextView).text = gender
            findViewById<TextView>(R.id.dobTextView).text = dob
        }
    }

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