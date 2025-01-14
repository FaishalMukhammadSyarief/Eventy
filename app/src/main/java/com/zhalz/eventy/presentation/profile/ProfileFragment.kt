package com.zhalz.eventy.presentation.profile

import android.os.Bundle
import android.view.View
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.user
import com.zhalz.eventy.databinding.FragmentProfileBinding
import com.zhalz.eventy.utils.extension.addMenu
import com.zhalz.eventy.utils.extension.clearMenu

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.fragment = this
        bind.person = user

    }

    fun toEdit() {
        bind.isEdit = true
        addMenu(R.menu.menu_profile) {
            if (it.itemId == R.id.menu_check) { updateProfile(); true}
            else false
        }
    }

    private fun updateProfile() {
        bind.isEdit = false
        clearMenu()
    }

}