package com.zhalz.eventy.presentation.profile

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseActivity
import com.zhalz.eventy.databinding.ActivityProfileBinding
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_PERSON

class ProfileActivity : BaseActivity<ActivityProfileBinding, ProfileViewModel>(R.layout.activity_profile) {

    private val person: Person? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_PERSON)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.person = person

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