package com.zhalz.eventy.utils

import android.app.Activity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.ColorInt

@Suppress("DEPRECATION")
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.statusBarColor = color
}

fun Activity.getAnim(animation: Int): Animation = AnimationUtils.loadAnimation(this, animation)
