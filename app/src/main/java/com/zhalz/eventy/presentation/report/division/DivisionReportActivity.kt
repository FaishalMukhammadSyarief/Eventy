package com.zhalz.eventy.presentation.report.division

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.activity.NoViewModelActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityDivisionReportBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.presentation.adapter.DivisionReportPagerAdapter
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DivisionReportActivity : NoViewModelActivity<ActivityDivisionReportBinding>(R.layout.activity_division_report) {

    val division: Division? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getParcelableExtra(EXTRA_DIVISION, Division::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_DIVISION)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.division = division

        initUI()
    }

    private fun initUI() {
        /** == VIEW PAGER == **/
        binding.viewPager.adapter = DivisionReportPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "TASK"
                1 -> tab.text = "IN PROGRESS"
                2 -> tab.text = "COMPLETED"
            }
        }.attach()
    }

}