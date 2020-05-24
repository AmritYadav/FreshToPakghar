package com.ftp.ui.dashboard.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.ftp.R
import com.ftp.ui.dashboard.models.OfferModel
import com.ftp.utils.inflateView
import com.ftp.utils.loadDrawableImage
import com.ftp.utils.loadImage
import com.smarteist.autoimageslider.SliderViewAdapter

class OfferSliderViewHolder(view: View) : SliderViewAdapter.ViewHolder(view) {

    fun bind(offerModel: OfferModel) {
        (itemView as ImageView).loadDrawableImage(offerModel.imgUrl)
    }

    companion object {
        fun create(parent: ViewGroup): OfferSliderViewHolder =
            OfferSliderViewHolder(parent.inflateView(R.layout.item_offer))
    }
}