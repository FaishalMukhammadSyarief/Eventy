package com.zhalz.eventy.presentation.report

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityReportBinding
import com.zhalz.eventy.databinding.ItemDivisionReportBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_EVENT
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportActivity : BaseActivity<ActivityReportBinding, ReportViewModel>(R.layout.activity_report) {

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionReportBinding, Division>(R.layout.item_division_report)
    }

    private val event: Event? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getParcelableExtra(EXTRA_EVENT, Event::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_EVENT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.divisionAdapter = divisionAdapter

        divisionAdapter.submitList(event?.divisionList)

    }

}