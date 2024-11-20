package com.zhalz.eventy.presentation.create_event

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityCreateEventBinding

class CreateEventActivity : BaseActivity<ActivityCreateEventBinding, CreateEventViewModel>(R.layout.activity_create_event) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

    }
}