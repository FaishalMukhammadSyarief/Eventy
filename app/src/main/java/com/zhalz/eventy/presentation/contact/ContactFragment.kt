package com.zhalz.eventy.presentation.contact

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentContactBinding
import com.zhalz.eventy.presentation.contact.collaborator.CollaboratorFragment
import com.zhalz.eventy.presentation.contact.friend.FriendFragment
import com.zhalz.eventy.utils.extension.addMenu
import com.zhalz.eventy.utils.extension.setupTabLayout

class ContactFragment : BaseFragment<FragmentContactBinding>(R.layout.fragment_contact) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() {
        setupTabLayout(
            binding?.viewPager,
            binding?.tabLayout,
            listOf(FriendFragment(), CollaboratorFragment()),
            listOf(getString(R.string.friend2), getString(R.string.collaborator))
        )

        addMenu(R.menu.menu_contact) {
            when (it.itemId) {
                R.id.menu_add_friend -> {
                    findNavController().navigate(R.id.action_contact_to_add_person_dialog)
                    true
                }
                else -> false
            }
        }
    }

}