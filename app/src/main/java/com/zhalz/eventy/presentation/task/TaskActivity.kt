package com.zhalz.eventy.presentation.task

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityTaskBinding

class TaskActivity : BaseActivity<ActivityTaskBinding, TaskViewModel>(R.layout.activity_task) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



    }
}