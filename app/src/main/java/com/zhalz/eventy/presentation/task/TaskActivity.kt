package com.zhalz.eventy.presentation.task

import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityTaskBinding
import com.zhalz.eventy.domain.model.Task
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_TASK

class TaskActivity : BaseActivity<ActivityTaskBinding, TaskViewModel>(R.layout.activity_task) {

    private val task: Task? by lazy {
        if (SDK_INT >= TIRAMISU) intent?.getParcelableExtra(EXTRA_TASK, Task::class.java)
        else @Suppress("DEPRECATION") intent?.getParcelableExtra(EXTRA_TASK)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.task = task

    }
}