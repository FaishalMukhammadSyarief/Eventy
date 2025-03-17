package com.zhalz.eventy.presentation.schedule

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.meetingList
import com.zhalz.eventy.databinding.FragmentScheduleBinding
import com.zhalz.eventy.databinding.ItemScheduleBinding
import com.zhalz.eventy.domain.model.Meet

class ScheduleFragment : BaseFragment<FragmentScheduleBinding>(R.layout.fragment_schedule) {

    private val schedule1Adapter by lazy {
        ReactiveListAdapter<ItemScheduleBinding, Meet>(R.layout.item_schedule)
    }

    private val schedule2Adapter by lazy {
        ReactiveListAdapter<ItemScheduleBinding, Meet>(R.layout.item_schedule)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.schedule1Adapter = schedule1Adapter
        binding?.schedule2Adapter = schedule2Adapter

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rv1?.addItemDecoration(it)
            binding?.rv2?.addItemDecoration(it)
        }

        schedule1Adapter.submitList(meetingList)
        schedule2Adapter.submitList(meetingList)
    }

}