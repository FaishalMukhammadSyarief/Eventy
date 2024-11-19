package com.zhalz.eventy.presentation.member

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.crocodic.core.base.activity.NoViewModelActivity
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.crocodic.core.extension.openActivity
import com.zhalz.eventy.R
import com.zhalz.eventy.databinding.ActivityMemberBinding
import com.zhalz.eventy.databinding.ItemContactBinding
import com.zhalz.eventy.domain.model.Event
import com.zhalz.eventy.domain.model.Person
import com.zhalz.eventy.presentation.profile.ProfileActivity
import com.zhalz.eventy.utils.Constanta.Parcel.EXTRA_EVENT
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

    private val event by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getParcelableExtra(EXTRA_EVENT, Event::class.java)
        else @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_EVENT)
    }

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

        managerAdapter.submitList(event?.managerList)
        coordinatorAdapter.submitList(event?.coordinatorList)
        memberAdapter.submitList(event?.memberList)

    }

    private fun toDetail(person: Person) = openActivity<ProfileActivity> { putExtra(EXTRA_PERSON, person) }

}