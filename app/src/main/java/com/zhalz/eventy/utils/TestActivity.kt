package com.zhalz.eventy.utils

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.zhalz.eventy.databinding.ActivityTestBinding
import com.zhalz.eventy.presentation.adapter.setupTabLayout
import com.zhalz.eventy.presentation.contact.ContactFragment

class TestActivity : AppCompatActivity() {

    private val binding by lazy { ActivityTestBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        setupTabLayout(binding.viewPager, binding.tabLayout, listOf(ContactFragment(), ContactFragment()), listOf("First", "First"))

    }

}