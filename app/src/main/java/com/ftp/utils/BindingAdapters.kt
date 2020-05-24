package com.ftp.utils

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ftp.R

@BindingAdapter("src")
fun setImageDrawable(view: ImageView, drawableRes: Int) {
    view.loadDrawableImage(drawableRes)
}

@BindingAdapter("strikeThrough")
fun strikeThroughText(view: TextView, text: Int) {
    val priceTxt = view.context.getString(R.string.price_placeholder, text.toString())
    view.text = priceTxt
    view.paintFlags = STRIKE_THRU_TEXT_FLAG
}