package com.zhalz.eventy.presentation.member

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.activity.NoViewModelActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityMemberBinding

class MemberActivity : NoViewModelActivity<ActivityMemberBinding>(R.layout.activity_member) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

    }
}