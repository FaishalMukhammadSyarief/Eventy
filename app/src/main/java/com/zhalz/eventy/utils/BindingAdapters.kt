package com.zhalz.eventy.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("attendees")
fun TextView.formatAttendees(attendant: Int) {
    "$attendant Attendees".also { this.text = it }
}

@BindingAdapter("textNumber")
fun TextView.textNumber(text: Int) {
    this.text = text.toString()
}