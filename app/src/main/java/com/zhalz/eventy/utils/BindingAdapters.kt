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
import com.zhalz.eventy.utils.extension.toBitmap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

@BindingAdapter("attendees")
fun TextView.formatAttendees(attendant: Int) =
    "$attendant Attendees".also { text = it }

@BindingAdapter("rupiah")
fun TextView.formatRupiah(amount: Int) =
    "Rp. $amount".also { text = it }

@BindingAdapter("textNumber")
fun TextView.textNumber(text: Int) =
    text.toString().also { this.text = it }

@BindingAdapter("textSemicolon")
fun TextView.textSemicolon(text: String) =
    ":  $text".also { this.text = it }

@BindingAdapter("listToText")
fun TextView.listToText(list: List<Person>) =
    ":  ${ list.joinToString(", ") { it.name } }".also { text = it }

@BindingAdapter("backgroundColor")
fun View.backgroundColor(color: Int) =
    this.setBackgroundColor(getColor(this.context, color))

@BindingAdapter("backgroundTint")
fun View.backgroundTint(color: Int) =
    this.background.setTint(getColor(this.context, color))

@BindingAdapter("indicatorColor")
fun CircularProgressIndicator.setIndicatorColor(color: Int) =
    this.setIndicatorColor(getColor(this.context, color))

@BindingAdapter("indicatorColor")
fun LinearProgressIndicator.setIndicatorColor(color: Int) =
    this.setIndicatorColor(getColor(this.context, color))

@BindingAdapter("tabIndicatorColor")
fun TabLayout.setTabIndicatorColor(color: Int) =
    this.setSelectedTabIndicatorColor(getColor(this.context, color))

@BindingAdapter("tabSelectedTextColor")
fun TabLayout.setTabSelectedTextColor(color: Int) =
    this.setTabTextColors(this.tabTextColors?.defaultColor ?: getColor(this.context, color), getColor(this.context, color))

@BindingAdapter("setDay")
fun TextView.setDay(date: String): String =
    date.formatDate("dd").also { this.text = it }

@BindingAdapter("setMonth")
fun TextView.setMonth(date: String): String =
    date.formatDate("MMM").also { this.text = it }

@BindingAdapter("setYear")
fun TextView.setYear(date: String): String =
    date.formatDate("yyyy").also { this.text = it }

@BindingAdapter("setDate")
fun TextView.setDate(date: String): String =
    date.formatDate("dd MMM yyyy").also { this.text = it }

@BindingAdapter("setTime")
fun TextView.setTime(date: String): String =
    date.formatDate("HH : mm").also { this.text = it }

@BindingAdapter("listImage")
fun OverlapImageListView.setOverlapImages(imageList: List<Int>) {
    CoroutineScope(Main).launch {
        val bitmapList = ArrayList(
            imageList.map { context.toBitmap(it) }
        )
        this@setOverlapImages.imageList = bitmapList
    }
}
