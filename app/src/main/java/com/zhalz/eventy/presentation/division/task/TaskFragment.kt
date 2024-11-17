package com.zhalz.eventy.presentation.division.task

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentTaskBinding
import com.zhalz.eventy.databinding.ItemTaskBinding
import com.zhalz.eventy.domain.model.Division
import com.zhalz.eventy.domain.model.Task
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_DIVISION

class TaskFragment : BaseFragment<FragmentTaskBinding>(R.layout.fragment_task) {

    private val taskAdapter by lazy {
        ReactiveListAdapter<ItemTaskBinding, Task>(R.layout.item_task)
    }

    val division: Division? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) activity?.intent?.getParcelableExtra(EXTRA_DIVISION, Division::class.java)
        else @Suppress("DEPRECATION") activity?.intent?.getParcelableExtra(EXTRA_DIVISION)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.taskAdapter = taskAdapter

        DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation).also {
            binding?.rvContact?.addItemDecoration(it)
        }

        taskAdapter.submitList(division?.task)

    }

//    private fun toDetail(task: Task) = context?.openActivity<ProfileActivity> { putExtra(EXTRA_TASK, task) }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}