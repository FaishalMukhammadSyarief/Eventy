package com.zhalz.eventy.presentation.profile

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.crocodic.core.base.adapter.ReactiveListAdapter
import com.zhalz.eventy.R
import com.zhalz.eventy.base.BaseFragment
import com.zhalz.eventy.data.eventList
import com.zhalz.eventy.data.user
import com.zhalz.eventy.databinding.FragmentProfileBinding
import com.zhalz.eventy.databinding.ItemHistoryBinding
import com.zhalz.eventy.domain.model.Event
import kotlin.getValue

class ProfileFragment : BaseFragment<FragmentProfileBinding>(R.layout.fragment_profile) {

    private val args by navArgs<ProfileFragmentArgs>()

    private val eventAdapter by lazy { ReactiveListAdapter<ItemHistoryBinding, Event>(R.layout.item_history) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind.apply {
            fragment = this@ProfileFragment
            person = args.person

            isUser = args.person.id == user.id
            rvMutualEvent.adapter = eventAdapter
        }

        eventAdapter.submitList(eventList)

    }

}