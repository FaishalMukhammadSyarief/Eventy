package com.zhalz.eventy.utils.extension

import android.graphics.Color

fun Int.lighten(factor: Float = 0.9f): Int {
    val red = Color.red(this)
    val green = Color.green(this)
    val blue = Color.blue(this)

    val newRed = (red + (255 - red) * factor).toInt()
    val newGreen = (green + (255 - green) * factor).toInt()
    val newBlue = (blue + (255 - blue) * factor).toInt()

    return Color.argb(Color.alpha(this), newRed, newGreen, newBlue)
}