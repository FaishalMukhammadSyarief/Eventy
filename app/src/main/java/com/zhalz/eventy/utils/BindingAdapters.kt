package com.zhalz.eventy.utils

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.BindingAdapter
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.google.android.material.tabs.TabLayout
import com.zhalz.eventy.domain.model.Person

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