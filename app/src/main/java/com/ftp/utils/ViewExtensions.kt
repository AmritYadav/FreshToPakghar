package com.ftp.utils

import android.graphics.Bitmap
import android.view.*
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.ftp.GlideApp
import com.ftp.R

/**
 * To be used with ProgressBar
 *
 * sets visibility state of the view to View.VISIBLE and
 * also disables user interaction while loading data
 */
fun View.visible(window: Window?) {
    this.visibility = View.VISIBLE
    window.disableViewInteraction()
}

/**
 * To be used with ProgressBar
 *
 * sets visibility state of the view to View.GONE and
 * also enables user interaction when data loading is complete
 */
fun View.gone(window: Window?) {
    this.visibility = View.GONE
    window.enableViewInteraction()
}

fun View.visibleGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}

fun Window?.disableViewInteraction() {
    this?.let {
        setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
    }
}

fun Window?.enableViewInteraction() {
    this?.let { clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE) }
}

/**
 * Inflate a [View] with given layoutId and attach it to the calling [ViewGroup].
 * @param layout Id of the layout to inflate.
 */
fun ViewGroup.inflateView(@LayoutRes layout: Int): View {
    return LayoutInflater.from(this.context).inflate(layout, this, false)
}

fun ImageView.loadImage(imgUrl: String?) {
    Glide.with(this)
        .asBitmap()
        .load(imgUrl)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(this)
}

fun ImageView.loadDrawableImage(imgUrl: Int) {
    Glide.with(this)
        .asBitmap()
        .load(imgUrl)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .into(this)
}

fun ImageView.loadImage(imgUrl: Int, view: View, callback: (colorInt: Int) -> Unit) {
    val defaultColor = ContextCompat.getColor(this.context, R.color.blue_grey_900)
    GlideApp.with(this.context)
        .asBitmap()
        .load(imgUrl)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.mipmap.ic_launcher)
        .listener(object : RequestListener<Bitmap> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Bitmap>?,
                isFirstResource: Boolean
            ): Boolean {
                callback.invoke(ColorUtils.setAlphaComponent(defaultColor, 100))
                return false
            }

            override fun onResourceReady(
                resource: Bitmap?, model: Any?,
                target: com.bumptech.glide.request.target.Target<Bitmap>?,
                dataSource: DataSource?, isFirstResource: Boolean
            ): Boolean {
                if (resource != null) {
                    val palette = Palette.from(resource).generate()
                    val color =
                        ColorUtils.setAlphaComponent(palette.getDarkVibrantColor(defaultColor), 100)
                    callback.invoke(color)
                    if (view is CardView) view.setCardBackgroundColor(color)
                    else view.setBackgroundColor(color)
                }
                return false
            }

        })
        .into(this)
}

fun <T : ViewDataBinding> ViewGroup.inflateDataBindingView(@LayoutRes layout: Int): T =
    DataBindingUtil.inflate(LayoutInflater.from(this.context), layout, this, false)