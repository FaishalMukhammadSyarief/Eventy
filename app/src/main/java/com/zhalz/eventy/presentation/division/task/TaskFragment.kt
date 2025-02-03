package com.zhalz.eventy.presentation.division.task

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.taskList
import com.zhalz.eventy.databinding.FragmentTaskBinding
import com.zhalz.eventy.databinding.ItemTaskBinding
import com.zhalz.eventy.domain.model.Task
import com.zhalz.eventy.presentation.task.TaskActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_TASK

class TaskFragment : BaseFragment<FragmentTaskBinding>(R.layout.fragment_task) {

    private val taskAdapter by lazy {
        ReactiveListAdapter<ItemTaskBinding, Task>(R.layout.item_task).initItem { _, data -> toDetail(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.taskAdapter = taskAdapter

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvContact?.addItemDecoration(it)
        }

        taskAdapter.submitList(taskList)

    }

    private fun toDetail(task: Task) = context?.openActivity<TaskActivity> { putExtra(EXTRA_TASK, task) }

}