package com.zhalz.eventy.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.getColor
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentHomeBinding
import com.zhalz.eventy.databinding.ItemEventBinding
import com.zhalz.eventy.databinding.ItemScheduleBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.domain.model.Schedule
import com.zhalz.eventy.domain.model.Task
import com.zhalz.eventy.presentation.event.EventActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_EVENT

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
        binding?.eventAdapter = eventAdapter
        binding?.scheduleAdapter = scheduleAdapter

        val scheduleList = listOf(
            Schedule(1, "Meeting 1", "Aug 10, 10:00 AM", "On Google Meet", 2),
            Schedule(2, "Meeting 2", "Aug 10, 03:00 PM", "On Zoom", 4)
        )

        val teamList = listOf(
            Person(1321422, "Rafi Raditya", "radit@mail.com", "087852163210", "Raditya", "rafi.raditya", "rafi"),
            Person(1233543, "Dandy Rama", "rama@mail.com", "089525223615", "Dandyy", "_dandy_", "rama"),
        )

        val managerList = listOf(
            Person(1092312, "Ikhsandi Saktiawan", "ikhsan@mail.com", "081326584842", "Ikhsandi", "_ikhsan_", "ikhsanD"),
        )

        val managerList2 = listOf(
            Person(1239112, "Fabe Bustanil", "fatichin@mail.com", "084562529854", "Fabe B F", "xbstnl", "bustanil"),
        )

        val taskList = listOf(
            Task(1092312, "Menyiapkan Panggung", "Augustus 22, 2024", "Rafi Raditya", teamList),
            Task(1239112, "Menyiapkan Banner", "Augustus 23, 2024", "Ramadandy", teamList),
        )

        val divisionList = listOf(
            Division(1092312, "Divisi Perlengkapan", getColor(requireContext(), R.color.blue), teamList, taskList),
            Division(1232991, "Divisi Acara", getColor(requireContext(), R.color.orange), teamList, taskList),
        )

        val eventList = listOf(
            Event(1, "Music Festival", "25 Aug, 2024", "Project Manager", "Sampookong", "Music", divisionList, managerList, teamList, teamList),
            Event(2, "Tech Conference", "26 Aug, 2024", "Member - Divisi Produksi", "City Hall, Main Street", "Expo", divisionList, managerList2, teamList, teamList),
        )

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvSchedule?.addItemDecoration(it)
        }

        scheduleAdapter.submitList(scheduleList)
        eventAdapter.submitList(eventList)

    }

    fun toSchedule() = findNavController().navigate(R.id.action_home_to_schedule)
    fun toHistory() = findNavController().navigate(R.id.action_home_to_history)

    private fun toDetail(event: Event) = context?.openActivity<EventActivity> { putExtra(EXTRA_EVENT, event) }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}