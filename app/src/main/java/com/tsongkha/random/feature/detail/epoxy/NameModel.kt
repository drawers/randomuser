package com.tsongkha.random.feature.detail.epoxy

import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.tsongkha.random.R
import com.tsongkha.random.common.BaseEpoxyHolder

@EpoxyModelClass(layout = R.layout.item_name)
abstract class NameModel : EpoxyModelWithHolder<NameModel.Holder>() {

    @EpoxyAttribute
    lateinit var pictureUrl: String

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var titleGender: String

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder.itemView) {
            findViewById<TextView>(R.id.nameTextView).text = name
            findViewById<TextView>(R.id.titleGenderTextView).text = titleGender
            findViewById<ImageView>(R.id.profileImageView).load(uri = pictureUrl) {
                transformations(CircleCropTransformation())
            }
        }
    }

    class Holder : BaseEpoxyHolder()
}
