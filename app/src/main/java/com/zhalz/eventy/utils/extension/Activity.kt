package com.zhalz.eventy.utils.extension

import android.app.Activity
import android.util.TypedValue
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("DEPRECATION")
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.statusBarColor = color
}

fun Activity.getWindowBackgroundColor() : Int {
    val typedValue = TypedValue().also {
        theme.resolveAttribute(android.R.attr.windowBackground, it, true)
    }
    return typedValue.data
}

fun Activity.getAnim(animation: Int): Animation = AnimationUtils.loadAnimation(this, animation)

fun AppCompatActivity.showMaterialDatePicker(onDateSelected: (String) -> Unit) {
    val datePicker = MaterialDatePicker.Builder.datePicker()
        .setTitleText("Select Start Date")
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .build()

    datePicker.addOnPositiveButtonClickListener {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            .format(Date(it))
        onDateSelected(formatter)
    }

    datePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
}

fun Fragment.addMenu(
    menuId: Int,
    onMenuItemSelected: (MenuItem) -> Boolean
) {
    requireActivity().addMenuProvider(object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) =
            menuInflater.inflate(menuId, menu)

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
            onMenuItemSelected(menuItem)

    }, this)
}
