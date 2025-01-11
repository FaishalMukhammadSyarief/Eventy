package com.zhalz.eventy.presentation.event

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.divisionList
import com.zhalz.eventy.databinding.FragmentEventBinding
import com.zhalz.eventy.databinding.ItemDivisionBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.presentation.create_schedule.CreateScheduleActivity
import com.zhalz.eventy.presentation.division.DivisionActivity
import com.zhalz.eventy.presentation.report.ReportActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION
import com.zhalz.eventy.utils.extension.navigate

class EventFragment : BaseFragment<FragmentEventBinding>(R.layout.fragment_event) {

    private val args by navArgs<EventFragmentArgs>()

    private val divisionAdapter by lazy {
        ReactiveListAdapter<ItemDivisionBinding, Division>(R.layout.item_division).initItem { _, data -> toDetail(data) }
    }

    private val activity by lazy { requireActivity() as AppCompatActivity }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() {
        activity.supportActionBar?.title = args.event.title

        binding?.apply {
            fragment = this@EventFragment
            adapter = divisionAdapter
            event = args.event
        }

        divisionAdapter.submitList(divisionList)
    }

    private fun toDetail(division: Division) = context?.openActivity<DivisionActivity> { putExtra(EXTRA_DIVISION, division) }
    fun toMember() = findNavController().navigate(R.id.action_event_to_member)
    fun toSpending() = EventFragmentDirections.actionEventToSpending(args.event.divisionList[0]).navigate(this)
    fun toMeeting() = context?.openActivity<CreateScheduleActivity>()
    fun toReport() = context?.openActivity<ReportActivity>()

}