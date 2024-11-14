package com.zhalz.eventy.presentation.history

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentHistoryBinding
import com.zhalz.eventy.databinding.ItemHistoryBinding
import com.zhalz.eventy.domain.model.Event

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {

    private val historyAdapter by lazy {
        ReactiveListAdapter<ItemHistoryBinding, Event>(R.layout.item_history)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.historyAdapter = historyAdapter

        val eventList = listOf(
            Event(1, "Music Festival", "25 Aug, 2024", "Project Manager", "Sampookong", "Music"),
            Event(2, "Tech Conference", "26 Aug, 2024", "Member - Divisi Produksi", "City Hall, Main Street", "Expo"),
        )

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvHistory?.addItemDecoration(it)
        }

        historyAdapter.submitList(eventList)
        binding?.historyAdapter = historyAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}