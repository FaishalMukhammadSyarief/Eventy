package com.zhalz.eventy.utils.extension

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Bitmap
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorInt
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.circleCropTransform
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.zhalz.eventy.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("DEPRECATION")
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.statusBarColor = color
}

fun Activity.closeKeyboard() {
    val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

fun Activity.getAnim(animation: Int): Animation = AnimationUtils.loadAnimation(this, animation)

fun Fragment.showMaterialDatePicker(onDateSelected: (String) -> Unit) {
    val datePicker = MaterialDatePicker.Builder.datePicker()
        .setTitleText("Select Start Date")
        .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
        .build()

    datePicker.addOnPositiveButtonClickListener {
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            .format(Date(it))
        onDateSelected(formatter)
    }

    datePicker.show(requireActivity().supportFragmentManager, "MATERIAL_DATE_PICKER")
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

    }, viewLifecycleOwner)
}

/*fun Fragment.clearMenu() =
    requireActivity().addMenuProvider(object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) = menu.clear()

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean = false
    }, viewLifecycleOwner)*/

fun Context.toBitmap(url: String): Bitmap = Glide.with(this)
    .asBitmap()
    .load(url)
    .apply(circleCropTransform())
    .submit()
    .get()

fun Fragment.showSnackBar(message: String?) =
    Snackbar.make(
        this.requireActivity().window.decorView,
        message.toString(),
        Snackbar.LENGTH_SHORT
    ).show()

fun Activity.showDialog(
    title: String,
    message: String,
    icon: Int,
    positiveAction: () -> Unit = {},
) {
    MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setMessage(message)
        .setIcon(icon)
        .setCancelable(false)
        .setPositiveButton(R.string.action_positive) { dialog, _ ->
            positiveAction()
            dialog.dismiss()
        }
        .setNegativeButton(R.string.action_neutral) { dialog, _ ->
            dialog.dismiss()
        }
        .show()
}