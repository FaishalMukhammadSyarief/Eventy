package com.zhalz.eventy.utils

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.databinding.BindingAdapter

@BindingAdapter("attendees")
fun TextView.formatAttendees(attendant: Int) {
    "$attendant Attendees".also { this.text = it }
}

@BindingAdapter("textNumber")
fun TextView.textNumber(text: Int) {
    this.text = text.toString()
}

@BindingAdapter("setBackground")
fun View.setBackground(color: Int) {
    this.setBackgroundColor(getColor(this.context, color))
}