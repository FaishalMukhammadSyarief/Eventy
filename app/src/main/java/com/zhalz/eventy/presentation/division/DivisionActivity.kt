package com.zhalz.eventy.presentation.division

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityDivisionBinding

class DivisionActivity : BaseActivity<ActivityDivisionBinding, DivisionViewModel>(R.layout.activity_division) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

    }
}