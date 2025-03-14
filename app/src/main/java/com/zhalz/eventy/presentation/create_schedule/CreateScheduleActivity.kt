package com.zhalz.eventy.presentation.create_schedule

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityCreateScheduleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateScheduleActivity : BaseActivity<ActivityCreateScheduleBinding, CreateScheduleViewModel>(R.layout.activity_create_schedule) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_check) finish()
            true
        }

    }
}