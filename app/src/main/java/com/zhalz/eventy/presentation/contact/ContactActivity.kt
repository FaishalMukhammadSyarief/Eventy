package com.zhalz.eventy.presentation.contact

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.activity.NoViewModelActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityContactBinding

class ContactActivity : NoViewModelActivity<ActivityContactBinding>(R.layout.activity_contact) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

    }
}