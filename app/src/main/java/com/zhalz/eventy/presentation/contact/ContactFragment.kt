package com.zhalz.eventy.presentation.contact

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.databinding.FragmentContactBinding
import com.zhalz.eventy.presentation.contact.collaborator.CollaboratorFragment
import com.zhalz.eventy.presentation.contact.friend.FriendFragment
import com.zhalz.eventy.utils.extension.setupWithTabLayout

class ContactFragment : BaseFragment<FragmentContactBinding>(R.layout.fragment_contact) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

    }

    private fun initUI() {

        binding?.apply {
            viewPager.setupWithTabLayout(
                requireActivity(),
                tabLayout,
                listOf(FriendFragment(), CollaboratorFragment()),
                listOf(getString(R.string.friend2), getString(R.string.collaborator))
            )
        }

        requireActivity().addMenuProvider(object : MenuProvider {

            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_contact, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem) =
                when (menuItem.itemId) {
                    R.id.menu_add_friend -> {
                        context?.tos("lol")
                        true
                    }
                    else -> false
                }
            }
            , viewLifecycleOwner)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}