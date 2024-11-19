package com.zhalz.eventy.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.tabs.TabLayout

@BindingAdapter("attendees")
fun TextView.formatAttendees(attendant: Int) =
    "$attendant Attendees".also { this.text = it }

@BindingAdapter("textNumber")
fun TextView.textNumber(text: Int) =
    text.toString().also { this.text = it }

@BindingAdapter("indicatorColor")
fun CircularProgressIndicator.setIndicatorColor(color: Int) =
    this.setIndicatorColor(color)

@BindingAdapter("tabIndicatorColor")
fun TabLayout.setTabIndicatorColor(color: Int) =
    this.setSelectedTabIndicatorColor(color)

@BindingAdapter("tabSelectedTextColor")
fun TabLayout.setTabSelectedTextColor(color: Int) =
    this.setTabTextColors(this.tabTextColors?.defaultColor ?: color, color)