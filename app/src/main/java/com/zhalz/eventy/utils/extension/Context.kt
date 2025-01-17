package com.zhalz.eventy.utils.extension

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.circleCropTransform
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zhalz.eventy.presentation.adapter.PagerAdapter
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("DEPRECATION")
fun Activity.setStatusBarColor(@ColorInt color: Int) {
    window.statusBarColor = color
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

fun Fragment.setupTabLayout(
    viewPager2: ViewPager2?,
    tabLayout: TabLayout?,
    fragments: List<Fragment>,
    titles: List<String>
) {
    if (viewPager2 == null || tabLayout == null) return

    viewPager2.adapter = PagerAdapter(requireActivity(), fragments)

    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.text = titles[position]
    }.attach()
}

suspend fun Context.toBitmap(@DrawableRes drawable: Int): Bitmap =
    withContext(IO) {
        Glide.with(this@toBitmap)
            .asBitmap()
            .load(drawable)
            .apply(circleCropTransform())
            .submit()
            .get()
    }