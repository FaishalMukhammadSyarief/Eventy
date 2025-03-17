package com.zhalz.eventy.presentation.adapter

import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PagerAdapter(activity: FragmentActivity, private val items: List<() -> Fragment>) : FragmentStateAdapter(activity) {

    override fun getItemCount() = items.size

    override fun createFragment(position: Int) = items[position]()

}

fun Activity.setupTabLayout(
    viewPager2: ViewPager2,
    tabLayout: TabLayout,
    fragments: List<() -> Fragment>,
    titles: List<String>,
    icon: List<Drawable>? = null
) {
    viewPager2.adapter = PagerAdapter(this as AppCompatActivity, fragments)

    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.text = titles[position]
        tab.icon = icon?.get(position)
    }.attach()
}