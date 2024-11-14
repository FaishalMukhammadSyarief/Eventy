package com.zhalz.eventy.presentation.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentHomeBinding
import com.zhalz.eventy.databinding.ItemEventBinding
import com.zhalz.eventy.databinding.ItemScheduleBinding
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Schedule

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val scheduleAdapter by lazy {
        ReactiveListAdapter<ItemScheduleBinding, Schedule>(R.layout.item_schedule)
    }

    private val eventAdapter by lazy {
        ReactiveListAdapter<ItemEventBinding, Event>(R.layout.item_event)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.eventAdapter = eventAdapter
        binding?.scheduleAdapter = scheduleAdapter

        val scheduleList = listOf(
            Schedule(1, "Meeting 1", "Aug 10, 10:00 AM", "On Google Meet", 2),
            Schedule(2, "Meeting 2", "Aug 10, 03:00 PM", "On Zoom", 4)
        )

        val eventList = listOf(
            Event(1, "Music Festival", "25 Aug, 2024", "Project Manager", "Music"),
            Event(2, "Tech Conference", "26 Aug, 2024", "Member - Divisi Produksi", "Expo"),
        )

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvSchedule?.addItemDecoration(it)
        }

        scheduleAdapter.submitList(scheduleList)
        eventAdapter.submitList(eventList)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}