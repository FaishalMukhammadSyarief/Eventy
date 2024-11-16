package com.zhalz.eventy.presentation.history

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentHistoryBinding
import com.zhalz.eventy.databinding.ItemHistoryBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.presentation.event.EventActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_EVENT

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {

    private val historyAdapter by lazy {
        ReactiveListAdapter<ItemHistoryBinding, Event>(R.layout.item_history).initItem { _, data -> toDetail(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.historyAdapter = historyAdapter

        val teamList = listOf(
            Person(1092312, "Ikhsandi Saktiawan", "ikhsan@mail.com"),
            Person(1239112, "Fabe Bustanil", "fatichin@mail.com"),
        )

        val divisionList = listOf(
            Division(1092312, "Divisi Perlengkapan", R.color.blue, teamList),
            Division(1232991, "Divisi Acara", R.color.yellow, teamList),
        )

        val eventList = listOf(
            Event(1, "Music Festival", "25 Aug, 2024", "Project Manager", "Sampookong", "Music", divisionList),
            Event(2, "Tech Conference", "26 Aug, 2024", "Member - Divisi Produksi", "City Hall, Main Street", "Expo", divisionList),
        )

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvHistory?.addItemDecoration(it)
        }

        historyAdapter.submitList(eventList)
        binding?.historyAdapter = historyAdapter

    }

    private fun toDetail(event: Event) = context?.openActivity<EventActivity> { putExtra(EXTRA_EVENT, event) }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}