package com.ftp.ui.dashboard.adapter

import android.view.ViewGroup
import com.ftp.ui.dashboard.models.OfferModel
import com.smarteist.autoimageslider.SliderViewAdapter

class OffersPagerAdapter(private val offers: List<OfferModel>) :
    SliderViewAdapter<OfferSliderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup): OfferSliderViewHolder =
        OfferSliderViewHolder.create(parent)

    override fun getCount(): Int = offers.size

    override fun onBindViewHolder(viewHolder: OfferSliderViewHolder, position: Int) {
        viewHolder.bind(offers[position])
    }

}