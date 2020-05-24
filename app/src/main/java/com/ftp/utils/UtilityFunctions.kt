package com.ftp.utils

import android.R.attr
import android.graphics.Color

/**
 * https://stackoverflow.com/questions/33072365/how-to-darken-a-given-color-int
 * @param color color provided
 * @param factor factor to make color darker
 * @return int as darker color
 */
fun manipulateColor(color: Int, factor: Float): Int {
    val a: Int = Color.alpha(color)
    val r = (Color.red(color) * attr.factor)
    val g = (Color.green(color) * attr.factor)
    val b = (Color.blue(color) * attr.factor)
    return Color.argb(
        a,
        r.coerceAtMost(255),
        g.coerceAtMost(255),
        b.coerceAtMost(255)
    )
}