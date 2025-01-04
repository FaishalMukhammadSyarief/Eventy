package com.zhalz.eventy.presentation.report

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.data.divisionList
import com.zhalz.eventy.databinding.ActivityReportBinding
import com.zhalz.eventy.databinding.ItemDivisionReportBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.presentation.report.division.DivisionReportActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportActivity : BaseActivity<ActivityReportBinding, ReportViewModel>(R.layout.activity_report) {

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionReportBinding, Division>(R.layout.item_division_report).initItem { _, data -> toDetail(data) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.divisionAdapter = divisionAdapter

        divisionAdapter.submitList(divisionList)

    }

    private fun toDetail(division: Division) = openActivity<DivisionReportActivity> { putExtra(EXTRA_DIVISION, division) }

}