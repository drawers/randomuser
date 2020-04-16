package com.tsongkha.random.list.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.tsongkha.random.R

@EpoxyModelClass(layout = R.layout.item_user_placeholder)
abstract class UserPlaceholderModel : EpoxyModel<View>()