package com.zhalz.eventy.presentation.main.history

import android.os.Bundle
import android.view.View
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.eventList
import com.zhalz.eventy.databinding.FragmentHistoryBinding
import com.zhalz.eventy.databinding.ItemHistoryBinding
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.utils.extension.addDivider
import com.zhalz.eventy.utils.extension.navigate

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {

    private val historyAdapter by lazy {
        ReactiveListAdapter<ItemHistoryBinding, Event>(R.layout.item_history).initItem { _, data -> toDetail(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

        historyAdapter.submitList(eventList)
    }

    private fun initUI() = binding?.rvHistory?.apply {
        addDivider(requireContext())
        adapter = historyAdapter
    }

    private fun toDetail(event: Event) = HistoryFragmentDirections.actionHistoryToEvent(event).navigate(this)

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}