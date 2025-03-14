package com.zhalz.eventy.presentation.member

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.data.managerList
import com.zhalz.eventy.data.teamList
import com.zhalz.eventy.databinding.ActivityMemberBinding
import com.zhalz.eventy.databinding.ItemContactBinding
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.presentation.dialog.add_person.AddPersonFragment
import com.zhalz.eventy.presentation.profile.ProfileActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_PERSON

class MemberActivity : NoViewModelActivity<ActivityMemberBinding>(R.layout.activity_member) {

    private val managerAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact).initItem { _, data -> toDetail(data) }
    }

    private val coordinatorAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact).initItem { _, data -> toDetail(data) }
    }

    private val memberAdapter by lazy {
        ReactiveListAdapter<ItemContactBinding, Person>(R.layout.item_contact).initItem { _, data -> toDetail(data) }
    }

    /*private val event by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getParcelableExtra(EXTRA_EVENT, Event::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_EVENT)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding.activity = this
        binding.managerAdapter = managerAdapter
        binding.coordinatorAdapter = coordinatorAdapter
        binding.memberAdapter = memberAdapter


        DividerItemDecoration(this, LinearLayoutManager(this).orientation).also {
            binding.rvManager.addItemDecoration(it)
            binding.rvCoordinator.addItemDecoration(it)
            binding.rvMember.addItemDecoration(it)
        }

        managerAdapter.submitList(managerList)
        coordinatorAdapter.submitList(teamList)
        memberAdapter.submitList(teamList)

        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_add_friend -> AddPersonFragment().show(supportFragmentManager, AddPersonFragment::class.java.simpleName)
            }
            true
        }

    }

    private fun toDetail(person: Person) = openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, person) }

}