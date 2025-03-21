package com.zhalz.eventy.utils

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.ContextCompat.getDrawable
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.tabs.TabLayout
import com.zen.overlapimagelistview.OverlapImageListView
import com.zhalz.eventy.R
import com.zhalz.eventy.utils.extension.formatDate
import com.zhalz.eventy.utils.extension.lighten
import com.zhalz.eventy.utils.extension.recognizeDate
import com.zhalz.eventy.utils.extension.toBitmap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/*  Text View  */
@BindingAdapter(value = ["startDate", "endDate"], requireAll = true)
fun TextView.setHourRange(start: String?, end: String?) {
    val range = "${start?.formatDate("HH:mm")} - ${end?.formatDate("HH:mm")}"
    text = range
}

@BindingAdapter("setHour")
fun TextView.setHour(date: String?) {
    text = date?.formatDate("HH : mm")
}

@BindingAdapter("setDay")
fun TextView.setDay(date: String?) {
    text = date?.formatDate("dd")
}

@BindingAdapter("setMonth")
fun TextView.setMonth(date: String?) {
    text = date?.formatDate("MMM")
}

@BindingAdapter("setYear")
fun TextView.setYear(date: String?) {
    text = date?.formatDate("yyyy")
}

@BindingAdapter("setDate")
fun TextView.setDate(date: String?) {
    text = date?.recognizeDate(context, "dd MMM yyyy")
}

/*  Set Color  */
@BindingAdapter("backgroundTint")
fun View.backgroundTint(color: Int) =
    background.setTint(getColor(context, color))

@BindingAdapter("lightenBackgroundTint")
fun View.lightenBackgroundTint(color: Int) =
    background.setTint(getColor(context, color).lighten())

@BindingAdapter("iconTint")
fun ImageView.setIconTint(color: Int) {
    imageTintList = ColorStateList.valueOf(getColor(context, color))
}

@BindingAdapter("icon")
fun ImageView.setIcon(iconRes: Int) {
    setImageDrawable(getDrawable(context, iconRes))
}

@BindingAdapter("indicatorColor")
fun CircularProgressIndicator.setIndicatorColor(color: Int) =
    setIndicatorColor(getColor(context, color))

/*@BindingAdapter("indicatorColor")
fun LinearProgressIndicator.setIndicatorColor(color: Int) =
    setIndicatorColor(getColor(context, color))*/

@BindingAdapter("tabIndicatorColor")
fun TabLayout.setTabIndicatorColor(color: Int) =
    setSelectedTabIndicatorColor(getColor(context, color))

@BindingAdapter("tabTextSelectedColor")
fun TabLayout.setTabTextSelectedColor(color: Int) =
    setTabTextColors(
        tabTextColors?.defaultColor ?: getColor(context, color),
        getColor(context, color)
    )

@BindingAdapter("tabIconSelectedColor")
fun TabLayout.setTabIconSelectedColor(color: Int) {
    val states = arrayOf(
        intArrayOf(android.R.attr.state_selected),
        intArrayOf(-android.R.attr.state_selected)
    )

    val colors = intArrayOf(
        getColor(context, color),
        getColor(context, R.color.text_grey)
    )

    tabIconTint = ColorStateList(states, colors)
}

/*  Image  */
@BindingAdapter("listImage")
fun OverlapImageListView.setOverlapImages(listImage: List<String>) = CoroutineScope(IO).launch {
    imageList = ArrayList(
        listImage.map { context.toBitmap(it) }
    )
}

@BindingAdapter("imageUrl")
fun ShapeableImageView.setImageUrl(url: String?) =
    Glide.with(context)
        .load("http://project.crocodic.academy/eventyapp/storage/$url")
        .into(this)