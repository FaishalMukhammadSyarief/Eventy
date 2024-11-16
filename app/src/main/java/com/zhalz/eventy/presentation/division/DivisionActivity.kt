package com.zhalz.eventy.presentation.division

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.google.android.material.tabs.TabLayoutMediator
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.presentation.adapter.DivisionPagerAdapter
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION

class DivisionActivity : BaseActivity<ActivityDivisionBinding, DivisionViewModel>(R.layout.activity_division) {

    private val division: Division? by lazy {
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
        binding.viewPager.adapter = DivisionPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "TASK"
                1 -> tab.text = "IN PROGRESS"
                2 -> tab.text = "COMPLETED"
            }
        }.attach()
    }

}