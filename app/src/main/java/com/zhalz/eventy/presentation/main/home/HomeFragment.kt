package com.zhalz.eventy.presentation.main.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle.State.STARTED
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.taskList
import com.zhalz.eventy.databinding.FragmentHomeBinding
import com.zhalz.eventy.databinding.ItemEventBinding
import com.zhalz.eventy.databinding.ItemTaskBinding
import com.zhalz.eventy.domain.common.ApiResult
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Task
import com.zhalz.eventy.utils.extension.navigate
import com.zhalz.eventy.utils.extension.showSnackBar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    val viewModel by viewModels<HomeViewModel>()

    private val taskAdapter by lazy {
        ReactiveListAdapter<ItemTaskBinding, Task>(R.layout.item_task).initItem { _, data -> toTaskDetail(data) }
    }

    private val eventAdapter by lazy {
        ReactiveListAdapter<ItemEventBinding, Event>(R.layout.item_event).initItem { _, data -> toEvent(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

        taskAdapter.submitList(taskList)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(STARTED) {
                getEvents()
            }
        }

    }

    private fun initUI() = binding?.let {
        it.fragment = this
        it.rvTask.adapter = taskAdapter
        it.rvEvent.adapter = eventAdapter
    }

    private suspend fun getEvents(): Unit = viewModel.eventsState.collect {
        when (it) {
            is ApiResult.Loading -> {}
            is ApiResult.Success -> eventAdapter.submitList(it.data?.data)
            is ApiResult.Error -> showSnackBar(it.message.orEmpty())
        }
    }

    fun toTask() = findNavController().navigate(R.id.action_home_to_task)
    fun toHistory() = findNavController().navigate(R.id.action_home_to_history)

    private fun toTaskDetail(task: Task) = HomeFragmentDirections.actionHomeToTaskDetail(task).navigate(this)
    private fun toEvent(event: Event) = HomeFragmentDirections.actionHomeToEvent(event.title.orEmpty()).navigate(this)

}