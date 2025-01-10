package com.zhalz.eventy.presentation.member

import android.os.Bundle
import android.view.View
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.crocodic.core.extension.tos
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.managerList
import com.zhalz.eventy.data.teamList
import com.zhalz.eventy.databinding.FragmentMemberBinding
import com.zhalz.eventy.databinding.ItemContactBinding
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.presentation.profile.ProfileActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_PERSON
import com.zhalz.eventy.utils.extension.addDivider
import com.zhalz.eventy.utils.extension.addMenu

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
        coordinatorAdapter.submitList(teamList)
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
                    context?.tos("Add Friend")
                    true
                }
                else -> false
            }
        }
    }

    private fun toDetail(person: Person) = context?.openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, person) }

}