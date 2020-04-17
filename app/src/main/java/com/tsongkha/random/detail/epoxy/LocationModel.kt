package com.tsongkha.random.detail.epoxy

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.tsongkha.random.R
import com.tsongkha.random.base.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.item_location)
abstract class LocationModel : EpoxyModelWithHolder<LocationModel.Holder>() {

    @EpoxyAttribute
    lateinit var address: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder.itemView) {
            findViewById<TextView>(R.id.addressTextView).text = address
        }
    }

    class Holder : BaseEpoxyHolder()
}