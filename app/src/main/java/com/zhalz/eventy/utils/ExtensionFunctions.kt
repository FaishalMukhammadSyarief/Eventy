package com.zhalz.eventy.utils

import android.app.Activity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import com.google.android.material.datepicker.MaterialDatePicker.todayInUtcMilliseconds
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("DEPRECATION")
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.statusBarColor = color
}

fun Activity.getAnim(animation: Int): Animation = AnimationUtils.loadAnimation(this, animation)

fun AppCompatActivity.showMaterialDatePicker(onDateSelected: (String) -> Unit) {
    val datePicker = datePicker()
        .setTitleText("Select Start Date")
        .setSelection(todayInUtcMilliseconds())
        .build()

    datePicker.addOnPositiveButtonClickListener {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            .format(Date(it))
        onDateSelected(formatter)
    }

    datePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
}
