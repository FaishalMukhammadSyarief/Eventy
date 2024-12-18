package com.zhalz.eventy.utils

import android.app.Activity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import com.google.android.material.datepicker.MaterialDatePicker.todayInUtcMilliseconds
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.zhalz.eventy.R
import com.zhalz.eventy.presentation.adapter.PagerAdapter
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

fun AutoCompleteTextView.setDropdown(list: List<String?>, onSelected: (Int) -> Unit) {
    ArrayAdapter<String>(this.context, R.layout.dm_coordinator, list).also {
        setAdapter(it)
    }

    setOnItemClickListener { _, _, position, _ ->
        onSelected(position)
    }
}

fun ViewPager2.setupWithTabLayout(
    activity: AppCompatActivity,
    tabLayout: TabLayout,
    fragments: List<Fragment>,
    titles: List<String>
) {
    adapter = PagerAdapter(activity, fragments)

    TabLayoutMediator(tabLayout, this) { tab, position ->
        tab.text = titles[position]
    }.attach()
}

