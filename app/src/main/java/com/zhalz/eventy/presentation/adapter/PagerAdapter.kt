package com.zhalz.eventy.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: FragmentActivity, private val items: List<Fragment>) : FragmentStateAdapter(activity) {

    override fun getItemCount() = items.size

    override fun createFragment(position: Int) = items[position]

}