package com.tsongkha.random.list.epoxy

import android.widget.ImageView
import android.widget.TextView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.tsongkha.random.R
import com.tsongkha.random.base.BaseEpoxyHolder

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
            findViewById<ImageView>(R.id.thumbnailImageView).load(uri = thumbnail) {
                transformations(CircleCropTransformation())
            }
        }
    }

    class Holder : BaseEpoxyHolder()
}