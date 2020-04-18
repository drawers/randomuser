package com.tsongkha.random.feature.list.epoxy

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import coil.api.load
import coil.transform.CircleCropTransformation
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.tsongkha.random.R
import com.tsongkha.random.common.BaseEpoxyHolder
import com.tsongkha.random.common.domain.User

@EpoxyModelClass(layout = R.layout.item_user)
abstract class UserModel : EpoxyModelWithHolder<UserModel.Holder>() {

    @EpoxyAttribute
    lateinit var titleName: String

    @EpoxyAttribute
    lateinit var thumbnail: String

    @EpoxyAttribute
    lateinit var dob: String

    @EpoxyAttribute
    lateinit var gender: String

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var onClick: () -> Unit

    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder.itemView) {
            findViewById<ConstraintLayout>(R.id.userItemConstraintLayout).setOnClickListener { onClick() }
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