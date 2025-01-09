package com.zhalz.eventy.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.eventList
import com.zhalz.eventy.data.scheduleList
import com.zhalz.eventy.databinding.FragmentHomeBinding
import com.zhalz.eventy.databinding.ItemEventBinding
import com.zhalz.eventy.databinding.ItemScheduleBinding
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Schedule
import com.zhalz.eventy.utils.extension.addDivider
import com.zhalz.eventy.utils.extension.navigate

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val scheduleAdapter by lazy {
        ReactiveListAdapter<ItemScheduleBinding, Schedule>(R.layout.item_schedule)
    }

    private val eventAdapter by lazy {
        ReactiveListAdapter<ItemEventBinding, Event>(R.layout.item_event).initItem { _, data -> toDetail(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this

        initUI()

        scheduleAdapter.submitList(scheduleList)
        eventAdapter.submitList(eventList)

    }

    private fun initUI() {
        binding?.rvSchedule?.addDivider(requireContext())
        binding?.rvSchedule?.adapter = scheduleAdapter
        binding?.rvEvent?.adapter = eventAdapter
    }

    fun toSchedule() = findNavController().navigate(R.id.action_home_to_schedule)
    fun toHistory() = findNavController().navigate(R.id.action_home_to_history)

    private fun toDetail(event: Event) = HomeFragmentDirections.actionHomeToEvent(event).navigate(this)

}