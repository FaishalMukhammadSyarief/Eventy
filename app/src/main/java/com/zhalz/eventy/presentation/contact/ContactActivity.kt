package com.zhalz.eventy.presentation.contact

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.crocodic.core.base.activity.NoViewModelActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityContactBinding
import com.zhalz.eventy.presentation.contact.collaborator.CollaboratorFragment
import com.zhalz.eventy.presentation.contact.friend.FriendFragment
import com.zhalz.eventy.presentation.dialog.add_people.AddPeopleFragment
import com.zhalz.eventy.utils.extension.setupWithTabLayout

class ContactActivity : NoViewModelActivity<ActivityContactBinding>(R.layout.activity_contact) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this

        initUI()
    }

    private fun initUI() {
        binding.viewPager.setupWithTabLayout(
            this,
            binding.tabLayout,
            listOf(FriendFragment(), CollaboratorFragment()),
            listOf(getString(R.string.friend2), getString(R.string.collaborator))
        )

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_add_friend -> AddPeopleFragment().show(supportFragmentManager, AddPeopleFragment::class.java.simpleName)
            }
            true
        }
    }

}