package com.zhalz.eventy.presentation.profile

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity<ActivityProfileBinding, ProfileViewModel>(R.layout.activity_profile) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_check) updateProfile()
            true
        }

    }

    fun toEdit() = binding.apply {
        isEdit = true
        toolbar.inflateMenu(R.menu.menu_profile)
    }

    private fun updateProfile() = binding.apply {
        isEdit = false
        toolbar.menu.clear()
    }

}