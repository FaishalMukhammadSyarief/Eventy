package com.zhalz.eventy.presentation.event

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.presentation.create_schedule.CreateScheduleActivity
import com.zhalz.eventy.presentation.division.DivisionActivity
import com.zhalz.eventy.presentation.member.MemberActivity
import com.zhalz.eventy.presentation.report.ReportActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_EVENT
import com.zhalz.eventy.utils.extension.getWindowBackgroundColor
import com.zhalz.eventy.utils.extension.setStatusBarColor

class EventActivity : BaseActivity<ActivityEventBinding, EventViewModel>(R.layout.activity_event) {

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division).initItem { _, data -> toDetail(data) }
    }

    private val event: Event? by lazy {
        if (SDK_INT >= TIRAMISU) intent.getParcelableExtra(EXTRA_EVENT, Event::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_EVENT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setStatusBarColor(getWindowBackgroundColor())

        binding.activity = this
        binding.divisionAdapter = divisionAdapter
        binding.event = event

        divisionAdapter.submitList(event?.divisionList)

    }

    private fun toDetail(division: Division) = openActivity<DivisionActivity> { putExtra(EXTRA_DIVISION, division) }
    fun toMember() = openActivity<MemberActivity>()
    fun toMeeting() = openActivity<CreateScheduleActivity>()
    fun toReport() = openActivity<ReportActivity>()

}