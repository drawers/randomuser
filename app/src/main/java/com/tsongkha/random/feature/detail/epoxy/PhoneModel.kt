package com.tsongkha.random.feature.detail.epoxy

import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.tsongkha.random.R
import com.tsongkha.random.common.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.item_phone)
abstract class PhoneModel : EpoxyModelWithHolder<PhoneModel.Holder>() {

    @EpoxyAttribute
    lateinit var home: String

    @EpoxyAttribute
    lateinit var cell: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder.itemView) {
            findViewById<TextView>(R.id.primaryPhoneTextView).text = home
            findViewById<TextView>(R.id.secondaryPhoneTextView).text = cell
        }
    }

    class Holder : BaseEpoxyHolder()
}