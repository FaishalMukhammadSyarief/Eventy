package com.zhalz.eventy.presentation.report

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityReportBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReportActivity : BaseActivity<ActivityReportBinding, ReportViewModel>(R.layout.activity_report) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

    }
}