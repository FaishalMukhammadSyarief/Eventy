package com.zhalz.eventy.presentation.contact

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.activity.NoViewModelActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityContactBinding
import com.zhalz.eventy.presentation.adapter.ContactPagerAdapter

class ContactActivity : NoViewModelActivity<ActivityContactBinding>(R.layout.activity_contact) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        initUI()
    }

    private fun initUI() {
        /** == VIEW PAGER == **/
        binding.viewPager.adapter = ContactPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.friend2)
                1 -> tab.text = getString(R.string.collaborator)
            }
        }.attach()
    }

}