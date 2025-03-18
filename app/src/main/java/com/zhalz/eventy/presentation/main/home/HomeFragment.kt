package com.zhalz.eventy.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.eventList
import com.zhalz.eventy.data.taskList
import com.zhalz.eventy.databinding.FragmentHomeBinding
import com.zhalz.eventy.databinding.ItemEventBinding
import com.zhalz.eventy.databinding.ItemTaskBinding
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Task
import com.zhalz.eventy.utils.extension.navigate

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val taskAdapter by lazy {
        ReactiveListAdapter<ItemTaskBinding, Task>(R.layout.item_task).initItem { _, data -> toTaskDetail(data) }
    }

    private val eventAdapter by lazy {
        ReactiveListAdapter<ItemEventBinding, Event>(R.layout.item_event).initItem { _, data -> toEvent(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.fragment = this

        initUI()

        taskAdapter.submitList(taskList)
        eventAdapter.submitList(eventList)

    }

    private fun initUI() {
        binding?.rvTask?.adapter = taskAdapter
        binding?.rvEvent?.adapter = eventAdapter
    }

    fun toTask() = findNavController().navigate(R.id.action_home_to_task)
    fun toHistory() = findNavController().navigate(R.id.action_home_to_history)

    private fun toTaskDetail(task: Task) = HomeFragmentDirections.actionHomeToTaskDetail(task).navigate(this)
    private fun toEvent(event: Event) = HomeFragmentDirections.actionHomeToEvent(event).navigate(this)

}