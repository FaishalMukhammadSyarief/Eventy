package com.zhalz.eventy.presentation.task.task_detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentTaskBinding
import com.zhalz.eventy.databinding.FragmentTaskDetailBinding
import com.zhalz.eventy.presentation.event.EventFragmentArgs
import kotlin.getValue

class TaskDetailFragment : BaseFragment<FragmentTaskDetailBinding>(R.layout.fragment_task_detail) {

    private val args by navArgs<TaskDetailFragmentArgs>()

    private val activity by lazy { requireActivity() as AppCompatActivity }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() {
        activity.supportActionBar?.title = args.task.title
    }

}