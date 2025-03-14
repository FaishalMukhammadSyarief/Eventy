package com.zhalz.eventy.presentation.profile

import android.os.Bundle
import android.view.View
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.eventList
import com.zhalz.eventy.data.user
import com.zhalz.eventy.databinding.FragmentProfileBinding
import com.zhalz.eventy.databinding.ItemHistoryBinding
import com.zhalz.eventy.domain.model.Event

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    private val eventAdapter by lazy { ReactiveListAdapter<ItemHistoryBinding, Event>(R.layout.item_history) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.apply {
            fragment = this@ProfileFragment
            person = user
            isUser = user.id == 1234567
            rvMutualEvent.adapter = eventAdapter
        }

        eventAdapter.submitList(eventList)

    }

}