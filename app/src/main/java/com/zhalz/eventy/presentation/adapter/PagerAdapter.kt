package com.zhalz.eventy.presentation.adapter

import android.graphics.drawable.Drawable
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PagerAdapter(fragment: Fragment, private val items: List<() -> Fragment>) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = items.size

    override fun createFragment(position: Int): Fragment = items[position]()

}

fun Fragment.setupTabPager(
    viewPager2: ViewPager2,
    tabLayout: TabLayout,
    fragments: List<() -> Fragment>,
    titles: List<String>? = null,
    icon: List<Drawable?>? = null
) {
    viewPager2.adapter = PagerAdapter(this, fragments)

    TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
        tab.text = titles?.get(position)
        tab.icon = icon?.get(position)
    }.attach()
}