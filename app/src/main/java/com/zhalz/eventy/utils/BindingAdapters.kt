package com.zhalz.eventy.utils

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.BindingAdapter
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.tabs.TabLayout
import com.zen.overlapimagelistview.OverlapImageListView
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.utils.extension.formatDate
import com.zhalz.eventy.utils.extension.recognizeDate
import com.zhalz.eventy.utils.extension.toBitmap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/*  Text View  */
@BindingAdapter("listToText")
fun TextView.listToText(list: List<Person>) =
    ":  ${list.joinToString(", ") { it.name }}".also { text = it }

@BindingAdapter("setHour")
fun TextView.setHour(date: String) {
    text = date.formatDate("HH : mm")
}

@BindingAdapter("setDay")
fun TextView.setDay(date: String) {
    text = date.formatDate("dd")
}

@BindingAdapter("setMonth")
fun TextView.setMonth(date: String) {
    text = date.formatDate("MMM")
}

@BindingAdapter("setYear")
fun TextView.setYear(date: String) {
    text = date.formatDate("yyyy")
}

@BindingAdapter("setDate")
fun TextView.setDate(date: String) {
    text = date.recognizeDate(context, "dd MMM yyyy")
}

/*  Set Color  */
@BindingAdapter("backgroundTint")
fun View.backgroundTint(color: Int) =
    background.setTint(getColor(context, color))

@BindingAdapter("indicatorColor")
fun CircularProgressIndicator.setIndicatorColor(color: Int) =
    setIndicatorColor(getColor(context, color))

@BindingAdapter("indicatorColor")
fun LinearProgressIndicator.setIndicatorColor(color: Int) =
    setIndicatorColor(getColor(context, color))

@BindingAdapter("tabIndicatorColor")
fun TabLayout.setTabIndicatorColor(color: Int) =
    setSelectedTabIndicatorColor(getColor(context, color))

@BindingAdapter("tabSelectedTextColor")
fun TabLayout.setTabSelectedTextColor(color: Int) =
    setTabTextColors(
        tabTextColors?.defaultColor ?: getColor(context, color),
        getColor(context, color)
    )

/*  Overlap Image  */
@BindingAdapter("listImage")
fun OverlapImageListView.setOverlapImages(images: List<Int>) = CoroutineScope(IO).launch {
    imageList = ArrayList(
        images.map { context.toBitmap(it) }
    )
}