package com.zhalz.eventy.presentation.event

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityEventBinding

class EventActivity : BaseActivity<ActivityEventBinding, EventViewModel>(R.layout.activity_event) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

    }

}