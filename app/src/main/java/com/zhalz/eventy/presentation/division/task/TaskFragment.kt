package com.zhalz.eventy.presentation.division.task

import android.os.Bundle
import android.view.View
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.taskList
import com.zhalz.eventy.databinding.FragmentTaskBinding
import com.zhalz.eventy.databinding.ItemTaskBinding
import com.zhalz.eventy.domain.model.Task

class TaskFragment : BaseFragment<FragmentTaskBinding>(R.layout.fragment_task) {

    private val taskAdapter by lazy {
        ReactiveListAdapter<ItemTaskBinding, Task>(R.layout.item_task).initItem { _, data -> }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.taskAdapter = taskAdapter

        taskAdapter.submitList(taskList)

    }

    //private fun toDetail(person: Person) = ContactFragmentDirections.actionContactToProfile(person).navigate(this)

}