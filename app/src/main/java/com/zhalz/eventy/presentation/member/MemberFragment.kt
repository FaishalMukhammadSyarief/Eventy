package com.zhalz.eventy.presentation.member

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.managerList
import com.zhalz.eventy.data.managerList2
import com.zhalz.eventy.data.teamList
import com.zhalz.eventy.databinding.FragmentMemberBinding
import com.zhalz.eventy.databinding.ItemContactBinding
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.utils.extension.addDivider
import com.zhalz.eventy.utils.extension.addMenu
import com.zhalz.eventy.utils.extension.navigate

class MemberFragment : BaseFragment<FragmentMemberBinding>(R.layout.fragment_member) {

    private val managerAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact).initItem { _, data -> toDetail(data) }
    }

    private val coordinatorAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact).initItem { _, data -> toDetail(data) }
    }

    private val memberAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact).initItem { _, data -> toDetail(data) }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()

        managerAdapter.submitList(managerList)
        coordinatorAdapter.submitList(managerList2)
        memberAdapter.submitList(teamList)

    }

    private fun initUI() = binding?.apply {
        rvManager.apply {
            addDivider(requireContext())
            adapter = managerAdapter
        }
        rvCoordinator.apply {
            addDivider(requireContext())
            adapter = coordinatorAdapter
        }
        rvMember.apply {
            addDivider(requireContext())
            adapter = memberAdapter
        }

        addMenu(R.menu.menu_contact) {
            when (it.itemId) {
                R.id.menu_add_friend -> {
                    findNavController().navigate(R.id.action_member_to_add_person_dialog)
                    true
                }
                else -> false
            }
        }
    }

    private fun toDetail(person: Person) = MemberFragmentDirections.actionMemberToProfile(person).navigate(this)

}