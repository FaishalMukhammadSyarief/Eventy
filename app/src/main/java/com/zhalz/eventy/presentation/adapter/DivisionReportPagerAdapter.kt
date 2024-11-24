package com.zhalz.eventy.presentation.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zhalz.eventy.presentation.report.division.overview.OverviewFragment
import com.zhalz.eventy.presentation.report.division.spending.SpendingFragment

class DivisionReportPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int) =
        when(position) {
            0 -> OverviewFragment()
            else -> SpendingFragment()
        }

}